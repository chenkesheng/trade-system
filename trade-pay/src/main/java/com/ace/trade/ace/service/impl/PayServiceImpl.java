package com.ace.trade.ace.service.impl;

import com.ace.trade.ace.entity.PaidMQ;
import com.ace.trade.ace.entity.TradeMqProducerTemp;
import com.ace.trade.ace.entity.TradePay;
import com.ace.trade.ace.mapper.TradeMqProducerTempMapper;
import com.ace.trade.ace.mapper.TradePayMapper;
import com.ace.trade.ace.request.CallbackPaymentReq;
import com.ace.trade.ace.request.CreatePaymentReq;
import com.ace.trade.ace.response.CallbackPaymentRes;
import com.ace.trade.ace.response.CreatePaymentRes;
import com.ace.trade.ace.service.IPayService;
import com.ace.trade.common.constants.MQEnums;
import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.rocketmq.AceMQproducer;
import com.ace.trade.common.util.IDGenarator;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: cks
 * @Date: Created by 16:54 2018/8/14
 * @Package: com.ace.trade.ace.service.impl
 * @Description:
 */
public class PayServiceImpl implements IPayService {

    @Autowired
    private TradePayMapper tradePayMapper;

    @Autowired
    private TradeMqProducerTempMapper tradeMqProducerTempMapper;

    @Autowired
    private AceMQproducer aceMQproducer;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public CreatePaymentRes createPayment(CreatePaymentReq dto) {
        CreatePaymentRes createPaymentRes = new CreatePaymentRes();
        createPaymentRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getCode());
        createPaymentRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getDesc());
        try {
            TradePay tradePay = new TradePay();
            tradePay.setOrderId(dto.getOrderId());
            tradePay.setIsPaid(TradeEnums.YesOrNoEnum.YES.getCode());
            TradePay result = tradePayMapper.queryPay(tradePay);
            if (result != null) {
                throw new Exception("该订单已支付");
            }
            String payId = IDGenarator.generatorUUID();
            TradePay pay = new TradePay();
            pay.setOrderId(dto.getOrderId());
            pay.setIsPaid(TradeEnums.YesOrNoEnum.NO.getCode());
            pay.setPayAmount(dto.getPayAmount());
            pay.setPayId(payId);
            tradePayMapper.insert(pay);
            System.out.println("创建支付单成功:" + payId);
        } catch (Exception e) {
            createPaymentRes.setResultCode(TradeEnums.ResultEnum.FAIL.getCode());
            createPaymentRes.setResultCode(e.getMessage());
        }
        return createPaymentRes;
    }

    @Transactional
    @Override
    public CallbackPaymentRes callbackPayment(CallbackPaymentReq dto) {
        CallbackPaymentRes callbackPaymentRes = new CallbackPaymentRes();
        callbackPaymentRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getCode());
        callbackPaymentRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getDesc());
        try {
            //更新支付状态
            TradePay tradePay = tradePayMapper.selectByPrimaryKey(dto.getPayId());
            if (tradePay == null) {
                throw new RuntimeException("未找到支付订单");
            }
            if (tradePay.getIsPaid().equals(TradeEnums.YesOrNoEnum.YES.getCode())) {
                throw new RuntimeException("该订单已支付");
            }
            tradePay.setIsPaid(TradeEnums.YesOrNoEnum.YES.getCode());
            int i = tradePayMapper.updateByPrimaryKey(tradePay);
            //发送可靠消息
            if (i == 1) {
                final PaidMQ paidMQ = new PaidMQ();

                paidMQ.setOrderId(tradePay.getOrderId());
                paidMQ.setPayAmount(tradePay.getPayAmount());
                paidMQ.setPayId(tradePay.getPayId());

                final TradeMqProducerTemp tradeMqProducerTemp = new TradeMqProducerTemp();
                tradeMqProducerTemp.setGoupName("payProducerGroup");
                tradeMqProducerTemp.setMsgTag(tradePay.getPayId());
                tradeMqProducerTemp.setMsgKeys(MQEnums.TopicEnum.PAY_PAID.getTag());
                tradeMqProducerTemp.setMsgBody(JSON.toJSONString(paidMQ));
                tradeMqProducerTemp.setCreatTime(new Date());
                tradeMqProducerTempMapper.insert(tradeMqProducerTemp);
                //异步发送mq消息，发送成功清空发送表
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SendResult sendResult = aceMQproducer.senMessage(MQEnums.TopicEnum.PAY_PAID, paidMQ.getPayId(), JSON.toJSONString(paidMQ));
                            System.out.println(sendResult);
                            if (sendResult.getSendStatus().equals(SendStatus.SEND_OK)) {
                                TradeMqProducerTemp key = new TradeMqProducerTemp();
                                key.setGoupName(tradeMqProducerTemp.getGoupName());
                                key.setMsgTag(tradeMqProducerTemp.getMsgTag());
                                key.setMsgKeys(tradeMqProducerTemp.getMsgKeys());
                                tradeMqProducerTempMapper.delete(key);
                                System.out.println("删除消息成功");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                throw new RuntimeException("该订单已支付");
            }
        } catch (Exception e) {
            callbackPaymentRes.setResultCode(TradeEnums.ResultEnum.FAIL.getCode());
            callbackPaymentRes.setResultCode(e.getMessage());
        }
        return callbackPaymentRes;
    }
}
