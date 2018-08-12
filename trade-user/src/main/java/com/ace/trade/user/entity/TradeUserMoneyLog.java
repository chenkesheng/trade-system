package com.ace.trade.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeUserMoneyLog implements Serializable {
    private Integer userId;

    private String orderId;

    private Integer moneyLogType;

    private BigDecimal userMoney;

    private Date createTime;

    private static final long serialVersionUID = 1L;

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

    public Integer getMoneyLogType() {
        return moneyLogType;
    }

    public void setMoneyLogType(Integer moneyLogType) {
        this.moneyLogType = moneyLogType;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append(", moneyLogType=").append(moneyLogType);
        sb.append(", userMoney=").append(userMoney);
        sb.append(", createTime=").append(createTime);
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
        TradeUserMoneyLog other = (TradeUserMoneyLog) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getMoneyLogType() == null ? other.getMoneyLogType() == null : this.getMoneyLogType().equals(other.getMoneyLogType()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getMoneyLogType() == null) ? 0 : getMoneyLogType().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}