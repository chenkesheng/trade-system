package com.ace.trade.common.rocketmq;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * @Author: cks
 * @Date: Created by 11:03 2018/8/12
 * @Package: com.ace.trade.common.rocketmq
 * @Description: 处理消息接口
 */
public interface IMessageProcessor {
    /**
     * 处理消息接口
     *
     * @param messageExt
     * @return
     */
    boolean handleMessage(MessageExt messageExt);
}
