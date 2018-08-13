package com.ace.trade.common.rocketmq;

import com.ace.trade.common.constants.MQEnums;
import com.ace.trade.common.exception.AceMQException;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: cks
 * @Date: Created by 9:53 2018/8/12
 * @Package: com.ace.trade.common.rocketmq
 * @Description: mq生产者
 */
@Component
public class AceMQproducer {

    public static final Logger LOGGER = LoggerFactory.getLogger(AceMQproducer.class);

    private DefaultMQProducer producer;

    @Value("${rocketmq.producer.group.name}")
    private String groupName;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.max.message.size}")
    private int maxMessageSize;

    @Value("${rocketmq.send.msg.timeout}")
    private int sendMsgTimeout;


    public void init() throws AceMQException {
        if (StringUtils.isBlank(this.groupName)) {
            throw new AceMQException("groupName is blank!");
        }
        if (StringUtils.isBlank(this.namesrvAddr)) {
            throw new AceMQException("namesrvAddr is blank!");
        }
        this.producer = new DefaultMQProducer(this.groupName);

        this.producer.setNamesrvAddr(this.namesrvAddr);
        this.producer.setMaxMessageSize(this.maxMessageSize);
        this.producer.setSendMsgTimeout(this.sendMsgTimeout);
        try {
            this.producer.start();
            LOGGER.info(String.format("producer is start!!! groupName:[%s],namesrvAddr:[%s]", this.groupName, this.namesrvAddr));
        } catch (MQClientException e) {
            LOGGER.error(String.format("producer is start!!! groupName:[%s],namesrvAddr:[%s]", this.groupName, this.namesrvAddr), e);
            throw new AceMQException(e);
        }
    }

    public SendResult senMessage(String topic, String tags, String keys, String messageText) throws AceMQException {

        if (StringUtils.isBlank(topic)) {
            throw new AceMQException("topic is blank!");
        }
        if (StringUtils.isBlank(messageText)) {
            throw new AceMQException("messageText is blank!");
        }
        Message msg = new Message(topic, tags, keys, messageText.getBytes());

        try {
            SendResult result = this.producer.send(msg);
            return result;
        } catch (Exception e) {
            LOGGER.error("send message error{}:", e.getMessage(), e);
            throw new AceMQException(e);
        }
    }

    public SendResult senMessage(MQEnums.TopicEnum topicEnum, String keys, String messageText) throws AceMQException {

        return this.senMessage(topicEnum.getTopic(), topicEnum.getTag(), keys, messageText);
    }
}
