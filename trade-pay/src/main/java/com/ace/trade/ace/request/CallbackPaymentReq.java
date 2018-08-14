package com.ace.trade.ace.request;

/**
 * @Author: cks
 * @Date: Created by 16:52 2018/8/14
 * @Package: com.ace.trade.ace.request
 * @Description:
 */
public class CallbackPaymentReq {

    private String isPaid;

    private String payId;

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }
}
