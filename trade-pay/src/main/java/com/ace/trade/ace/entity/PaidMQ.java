package com.ace.trade.ace.entity;

import java.math.BigDecimal;

/**
 * @Author: cks
 * @Date: Created by 17:27 2018/8/14
 * @Package: com.ace.trade.ace.entity
 * @Description: 发送协议
 */
public class PaidMQ {
    private String payId;

    private String orderId;

    private BigDecimal payAmount;

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
}
