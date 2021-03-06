package com.ace.trade.order.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: cks
 * @Date: Created by 11:41 2018/8/13
 * @Package: com.ace.trade.order.dto
 * @Description:
 */
public class ConfirmOrderReq implements Serializable {

    private Integer userId;

    private String address;

    private String consignee;

    private Integer goodsId;

    private Integer goodsNumber;

    private String couponId;

    /**
     * 余额支付
     */
    private BigDecimal moneyPaid;
    /**
     * 物品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 运费
     */
    private BigDecimal shippingFee;

    /**
     * 订单总价
     */
    private BigDecimal orderAmount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
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

    public BigDecimal getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(BigDecimal moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
}
