package com.ace.trade.ace.entity;

import java.util.Date;

/**
 * @Author: cks
 * @Date: Created by 17:30 2018/8/14
 * @Package: com.ace.trade.ace.entity
 * @Description:
 */
public class TradeMqProducerTemp {

    private String goupName;

    private String msgTag;

    private String msgKeys;

    private String msgBody;

    private Date creatTime;

    public String getGoupName() {
        return goupName;
    }

    public void setGoupName(String goupName) {
        this.goupName = goupName;
    }

    public String getMsgTag() {
        return msgTag;
    }

    public void setMsgTag(String msgTag) {
        this.msgTag = msgTag;
    }

    public String getMsgKeys() {
        return msgKeys;
    }

    public void setMsgKeys(String msgKeys) {
        this.msgKeys = msgKeys;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
