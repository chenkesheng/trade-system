package com.ace.trade.goods.entity;

/**
 * @Author: cks
 * @Date: Created by 15:21 2018/8/14
 * @Package: com.ace.trade.goods.entity
 * @Description:
 */
public class TradeMqConsumerLog {
    private String groupName;

    private String msgTags;

    private String msgKeys;

    private String msgId;

    private String msgBody;

    private String consumerStatus;

    private Integer consumerTimes;

    private String remark;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMsgTags() {
        return msgTags;
    }

    public void setMsgTags(String msgTags) {
        this.msgTags = msgTags;
    }

    public String getMsgKeys() {
        return msgKeys;
    }

    public void setMsgKeys(String msgKeys) {
        this.msgKeys = msgKeys;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getConsumerStatus() {
        return consumerStatus;
    }

    public void setConsumerStatus(String consumerStatus) {
        this.consumerStatus = consumerStatus;
    }

    public Integer getConsumerTimes() {
        return consumerTimes;
    }

    public void setConsumerTimes(Integer consumerTimes) {
        this.consumerTimes = consumerTimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TradeMqConsumerLog{" +
                "groupName='" + groupName + '\'' +
                ", msgTags='" + msgTags + '\'' +
                ", msgKeys='" + msgKeys + '\'' +
                ", msgId='" + msgId + '\'' +
                ", msgBody='" + msgBody + '\'' +
                ", consumerStatus='" + consumerStatus + '\'' +
                ", consumerTimes=" + consumerTimes +
                ", remark='" + remark + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
