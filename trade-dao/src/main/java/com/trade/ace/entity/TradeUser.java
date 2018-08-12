package com.trade.ace.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String userName;

    private String userPassword;

    private String userMobile;

    private Integer userScope;

    private Date userRegTime;

    private BigDecimal userMoney;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Integer getUserScope() {
        return userScope;
    }

    public void setUserScope(Integer userScope) {
        this.userScope = userScope;
    }

    public Date getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(Date userRegTime) {
        this.userRegTime = userRegTime;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userMobile=").append(userMobile);
        sb.append(", userScope=").append(userScope);
        sb.append(", userRegTime=").append(userRegTime);
        sb.append(", userMoney=").append(userMoney);
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
        TradeUser other = (TradeUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserMobile() == null ? other.getUserMobile() == null : this.getUserMobile().equals(other.getUserMobile()))
            && (this.getUserScope() == null ? other.getUserScope() == null : this.getUserScope().equals(other.getUserScope()))
            && (this.getUserRegTime() == null ? other.getUserRegTime() == null : this.getUserRegTime().equals(other.getUserRegTime()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserMobile() == null) ? 0 : getUserMobile().hashCode());
        result = prime * result + ((getUserScope() == null) ? 0 : getUserScope().hashCode());
        result = prime * result + ((getUserRegTime() == null) ? 0 : getUserRegTime().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        return result;
    }
}