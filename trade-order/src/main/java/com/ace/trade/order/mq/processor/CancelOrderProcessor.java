package com.ace.trade.order.mq.processor;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.rocketmq.CancelOrderMQ;
import com.ace.trade.common.rocketmq.IMessageProcessor;
import com.ace.trade.order.entity.TradeOrder;
import com.ace.trade.order.mapper.TradeOrderMapper;
import com.ace.trade.user.request.ChangeUserMoneyReq;
import com.ace.trade.user.service.IUserService;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * @Author: cks
 * @Date: Created by 9:52 2018/8/14
 * @Package: com.ace.trade.user.mq.processor
 * @Description: 订阅模块
 */
public class CancelOrderProcessor implements IMessageProcessor {

    public static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderProcessor.class);

    @Autowired
    private TradeOrderMapper tradeOrderMapper;

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
            TradeOrder tradeOrder = new TradeOrder();
            tradeOrder.setOrderId(cancelOrderMQ.getOrderId());
            tradeOrder.setOrderStatus(TradeEnums.OrderStatusEnum.CANCEL.getStatusCode());
            //todo 要改成selective
            tradeOrderMapper.updateByPrimaryKey(tradeOrder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
