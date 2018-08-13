package com.ace.trade.user.request;

import java.math.BigDecimal;

/**
 * @Author: cks
 * @Date: Created by 15:39 2018/8/13
 * @Package: com.ace.trade.user.dto
 * @Description:
 */
public class ChangeUserMoneyReq {
    private Integer userId;

    private BigDecimal userMoney;

    private String moneyLogType;

    private String orderId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public String getMoneyLogType() {
        return moneyLogType;
    }

    public void setMoneyLogType(String moneyLogType) {
        this.moneyLogType = moneyLogType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
