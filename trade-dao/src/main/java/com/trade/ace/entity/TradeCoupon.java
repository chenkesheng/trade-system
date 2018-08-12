package com.trade.ace.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeCoupon implements Serializable {
    private String couponId;

    private BigDecimal couponPrice;

    private Integer userId;

    private String orderId;

    private String isUser;

    private Date usedTime;


    private static final long serialVersionUID = 1L;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
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
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getIsUser() {
        return isUser;
    }

    public void setIsUser(String isUser) {
        this.isUser = isUser == null ? null : isUser.trim();
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", couponId=").append(couponId);
        sb.append(", couponPrice=").append(couponPrice);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append(", isUser=").append(isUser);
        sb.append(", usedTime=").append(usedTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TradeCoupon other = (TradeCoupon) that;
        return (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getCouponPrice() == null ? other.getCouponPrice() == null : this.getCouponPrice().equals(other.getCouponPrice()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getIsUser() == null ? other.getIsUser() == null : this.getIsUser().equals(other.getIsUser()))
            && (this.getUsedTime() == null ? other.getUsedTime() == null : this.getUsedTime().equals(other.getUsedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getCouponPrice() == null) ? 0 : getCouponPrice().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getIsUser() == null) ? 0 : getIsUser().hashCode());
        result = prime * result + ((getUsedTime() == null) ? 0 : getUsedTime().hashCode());
        return result;
    }
}