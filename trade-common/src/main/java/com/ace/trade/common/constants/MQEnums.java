package com.ace.trade.common.constants;

/**
 * @Author: cks
 * @Date: Created by 20:28 2018/8/13
 * @Package: com.ace.trade.common.constants
 * @Description:
 */
public class MQEnums {
    public enum TopicEnum {
        ORDER_CONFIRM("orderTopic", "confirm"),
        ORDER_CANCEL("orderTopic", "cancel"),
        PAY_PAID("payTopic", "paid");

        private String topic;
        private String tag;

        TopicEnum(String topic, String tag) {
            this.topic = topic;
            this.tag = tag;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }
}
