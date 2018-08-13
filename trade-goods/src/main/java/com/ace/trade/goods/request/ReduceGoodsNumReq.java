package com.ace.trade.goods.request;

/**
 * @Author: cks
 * @Date: Created by 15:37 2018/8/13
 * @Package: com.ace.trade.goods.dto
 * @Description:
 */
public class ReduceGoodsNumReq {
    private Integer goodsId;

    private Integer goodsNumber;

    private String orderId;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
