package com.ace.trade.common.rocketmq;

import com.ace.trade.common.exception.AceMQException;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: cks
 * @Date: Created by 10:53 2018/8/12
 * @Package: com.ace.trade.common.rocketmq
 * @Description:
 */
@Component
public class AceMQConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(AceMQConsumer.class);

    @Value("${rocketmq.consumer.group.name}")
    private String groupName;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.consumer.topic}")
    private String topic;

    private String tag = "*";//多个tag以||分割

    private int consumeThreadMin = 20;

    private int consumeThreadMax = 54;

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setConsumeThreadMin(int consumeThreadMin) {
        this.consumeThreadMin = consumeThreadMin;
    }

    public void setConsumeThreadMax(int consumeThreadMax) {
        this.consumeThreadMax = consumeThreadMax;
    }

    @Autowired
    private IMessageProcessor messageProcessor;

    public void init() throws AceMQException {
        if (StringUtils.isBlank(this.groupName)) {
            throw new AceMQException("groupName is blank!");
        }
        if (StringUtils.isBlank(this.namesrvAddr)) {
            throw new AceMQException("namesrvAddr is blank!");
        }
        if (StringUtils.isBlank(this.topic)) {
            throw new AceMQException("topic is blank!");
        }

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr(this.namesrvAddr);
        try {
            consumer.subscribe(topic, tag);
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.setConsumeThreadMin(consumeThreadMin);
            consumer.setConsumeThreadMax(consumeThreadMax);

            AceMessageListener listener = new AceMessageListener();
            listener.setMessageProcessor(messageProcessor);
            consumer.registerMessageListener(listener);
            consumer.start();
            LOGGER.info("consumer is start!!!groupName:{},topic:{},namesrvAddr{}", groupName, topic, namesrvAddr);
        } catch (MQClientException e) {
            LOGGER.error("consumer is error!!!groupName:{},topic:{},namesrvAddr{}", groupName, topic, namesrvAddr, e);
            throw new AceMQException(e);
        }
    }
}
