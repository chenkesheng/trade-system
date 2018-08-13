package com.ace.trade.common.rocketmq;

import java.math.BigDecimal;

/**
 * @Author: cks
 * @Date: Created by 20:38 2018/8/13
 * @Package: com.ace.trade.common.rocketmq
 * @Description:
 */
public class CancelOrderMQ {
    private String orderId;

    private Integer userId;

    private Integer goodsId;

    private Integer goodsNumber;

    private String couponId;

    private BigDecimal userMoney;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }
}
