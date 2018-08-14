package com.ace.trade.coupon.mq.processor;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.rocketmq.CancelOrderMQ;
import com.ace.trade.common.rocketmq.IMessageProcessor;
import com.ace.trade.coupon.request.ChangeCouponStatusReq;
import com.ace.trade.coupon.service.ICouponService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: cks
 * @Date: Created by 9:52 2018/8/14
 * @Package: com.ace.trade.user.mq.processor
 * @Description: 订阅模块
 */
public class CancelOrderProcessor implements IMessageProcessor {

    public static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderProcessor.class);

    @Autowired
    private ICouponService couponService;

    @Override
    public boolean handleMessage(MessageExt messageExt) {
        try {
            //消息内容
            String body = new String(messageExt.getBody(), "UTF-8");
            //消息id
            String msgId = messageExt.getMsgId();
            //标签
            String tags = messageExt.getTags();
            //业务主键
            String keys = messageExt.getKeys();

            LOGGER.info("order CancelOrderProcessor receive message:" + messageExt);

            CancelOrderMQ cancelOrderMQ = JSON.parseObject(body, CancelOrderMQ.class);
           if (!StringUtils.isEmpty(cancelOrderMQ.getCouponId())){
               ChangeCouponStatusReq changeCouponStatusReq = new ChangeCouponStatusReq();
               changeCouponStatusReq.setCouponId(cancelOrderMQ.getCouponId());
               changeCouponStatusReq.setOrderId(cancelOrderMQ.getOrderId());
               changeCouponStatusReq.setIsUsed(TradeEnums.YesOrNoEnum.NO.getCode());
               couponService.changeStatus(changeCouponStatusReq);
           }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
