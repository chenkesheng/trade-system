package com.ace.trade.coupon.request;

/**
 * @Author: cks
 * @Date: Created by 15:27 2018/8/13
 * @Package: com.ace.trade.coupon.dto
 * @Description:
 */
public class ChangeCouponStatusReq {

    private String couponId;

    private String isUsed;

    private String orderId;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
