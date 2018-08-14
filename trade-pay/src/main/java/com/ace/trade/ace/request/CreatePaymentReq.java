package com.ace.trade.ace.request;

import java.math.BigDecimal;

/**
 * @Author: cks
 * @Date: Created by 16:52 2018/8/14
 * @Package: com.ace.trade.ace.request
 * @Description:
 */
public class CreatePaymentReq {
    private String orderId;

    private BigDecimal payAmount;

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
