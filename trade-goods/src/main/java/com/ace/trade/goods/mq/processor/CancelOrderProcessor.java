package com.ace.trade.goods.mq.processor;

import com.ace.trade.common.constants.MQEnums;
import com.ace.trade.common.rocketmq.CancelOrderMQ;
import com.ace.trade.common.rocketmq.IMessageProcessor;
import com.ace.trade.goods.entity.TradeMqConsumerLog;
import com.ace.trade.goods.mapper.TradeMqConsumerLogMapper;
import com.ace.trade.goods.request.AddGoodsNumReq;
import com.ace.trade.goods.service.IGoodsService;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: cks
 * @Date: Created by 9:52 2018/8/14
 * @Package: com.ace.trade.user.mq.processor
 * @Description: 订阅模块
 */
@Component
public class CancelOrderProcessor implements IMessageProcessor {

    public static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderProcessor.class);

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private TradeMqConsumerLogMapper tradeMqConsumerLogMapper;

    @Override
    public boolean handleMessage(MessageExt messageExt) {
        TradeMqConsumerLog mqConsumerLog = null;
        try {
            String groupName = "goods_orderTopic_cancel_group";
            //消息内容
            String body = new String(messageExt.getBody(), "UTF-8");
            //消息id
            String msgId = messageExt.getMsgId();
            //标签
            String tags = messageExt.getTags();
            //业务主键
            String keys = messageExt.getKeys();

            LOGGER.info("order CancelOrderProcessor receive message:" + messageExt);

            TradeMqConsumerLog key = new TradeMqConsumerLog();
            key.setGroupName(groupName);
            key.setMsgTags(tags);
            key.setMsgKeys(keys);

            mqConsumerLog = tradeMqConsumerLogMapper.findById(key);
            if (mqConsumerLog != null){
                String status = mqConsumerLog.getConsumerStatus();
                if (MQEnums.ConsumerStatusEnum.SUCCESS.getStatusCode().equals(status)){
                    //返回成功，重复处理的消息
                    LOGGER.warn("已经处理过，不用在处理");
                    return true;
                }else if (MQEnums.ConsumerStatusEnum.PROCESSING.getStatusCode().equals(status)){
                    //返回失败，说明有消费者正在处理当中，稍后再试
                    LOGGER.warn("稍后再试");
                    return false;
                }else if (MQEnums.ConsumerStatusEnum.FAIL.getStatusCode().equals(status)){
                    if (mqConsumerLog.getConsumerTimes() >= 3){
                        //让这个消息不在重试，转人工处理
                        LOGGER.warn("超过三次不在处理");
                        return true;
                    }
                    //更新消息处理中状态
                    TradeMqConsumerLog updateMqConsumerLog = new TradeMqConsumerLog();
                    updateMqConsumerLog.setGroupName(mqConsumerLog.getGroupName());
                    updateMqConsumerLog.setMsgTags(mqConsumerLog.getMsgTags());
                    updateMqConsumerLog.setMsgKeys(mqConsumerLog.getMsgKeys());
                    updateMqConsumerLog.setConsumerStatus(MQEnums.ConsumerStatusEnum.PROCESSING.getStatusCode());
                    //防止并发 用乐观锁方式在数据库中用版本号控制
                    int i = tradeMqConsumerLogMapper.updateByKeySelective(updateMqConsumerLog);
                    if (i <= 0){
                        LOGGER.warn("并发更新处理状态，一会儿重试");
                        return false;
                    }
                }
            }else {
                //新插入去重表，并发时用主键冲突控制
                try {
                    mqConsumerLog.setGroupName(groupName);
                    mqConsumerLog.setMsgKeys(keys);
                    mqConsumerLog.setMsgTags(tags);
                    mqConsumerLog.setMsgId(msgId);
                    mqConsumerLog.setConsumerTimes(0);
                    mqConsumerLog.setMsgBody(body);
                    mqConsumerLog.setConsumerStatus(MQEnums.ConsumerStatusEnum.PROCESSING.getStatusCode());
                }catch (Exception e){
                   LOGGER.warn("主键冲突，说明有订阅正在处理，稍后再试");
                }

            }

            //业务逻辑处理
            CancelOrderMQ cancelOrderMQ = JSON.parseObject(body,CancelOrderMQ.class);
            AddGoodsNumReq addGoodsNumReq = new AddGoodsNumReq();
            addGoodsNumReq.setGoodsId(cancelOrderMQ.getGoodsId());
            addGoodsNumReq.setOrderId(cancelOrderMQ.getOrderId());
            addGoodsNumReq.setGoodsNumber(cancelOrderMQ.getGoodsNumber());
            goodsService.addGoodsNumber(addGoodsNumReq);

            //更新消息处理成功
            TradeMqConsumerLog updateMqConsumerLog = new TradeMqConsumerLog();
            updateMqConsumerLog.setGroupName(groupName);
            updateMqConsumerLog.setMsgTags(tags);
            updateMqConsumerLog.setMsgKeys(keys);
            updateMqConsumerLog.setConsumerStatus(MQEnums.ConsumerStatusEnum.SUCCESS.getStatusCode());
            updateMqConsumerLog.setConsumerTimes(mqConsumerLog.getConsumerTimes() + 1);
            tradeMqConsumerLogMapper.updatePrimaryKeySelective(updateMqConsumerLog);
            return true;
        } catch (Exception e) {
            //更新消息处理失败
            TradeMqConsumerLog updateMqConsumerLog = new TradeMqConsumerLog();
            updateMqConsumerLog.setGroupName(mqConsumerLog.getGroupName());
            updateMqConsumerLog.setMsgTags(mqConsumerLog.getMsgTags());
            updateMqConsumerLog.setMsgKeys(mqConsumerLog.getMsgKeys());
            updateMqConsumerLog.setConsumerStatus(MQEnums.ConsumerStatusEnum.FAIL.getStatusCode());
            updateMqConsumerLog.setConsumerTimes(mqConsumerLog.getConsumerTimes() + 1);
            tradeMqConsumerLogMapper.updatePrimaryKeySelective(updateMqConsumerLog);
            return false;
        }
    }
}
