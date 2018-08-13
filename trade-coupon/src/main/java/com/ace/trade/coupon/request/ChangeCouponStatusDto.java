package com.ace.trade.coupon.request;

/**
 * @Author: cks
 * @Date: Created by 15:27 2018/8/13
 * @Package: com.ace.trade.coupon.dto
 * @Description:
 */
public class ChangeCouponStatusDto {

    private String couponId;

    private Integer userId;

    private String orderId;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
