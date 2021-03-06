package com.trade.ace.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeOrder implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.order_status
     *
     * @mbg.generated
     */
    private String orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.pay_status
     *
     * @mbg.generated
     */
    private String payStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.shipping_status
     *
     * @mbg.generated
     */
    private String shippingStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.addres
     *
     * @mbg.generated
     */
    private String addres;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.consignee
     *
     * @mbg.generated
     */
    private String consignee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.goods_id
     *
     * @mbg.generated
     */
    private Integer goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.goods_number
     *
     * @mbg.generated
     */
    private Integer goodsNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.goods_price
     *
     * @mbg.generated
     */
    private BigDecimal goodsPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.goods_amount
     *
     * @mbg.generated
     */
    private BigDecimal goodsAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.shipping_fee
     *
     * @mbg.generated
     */
    private BigDecimal shippingFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.order_amoumt
     *
     * @mbg.generated
     */
    private BigDecimal orderAmoumt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.coupon_id
     *
     * @mbg.generated
     */
    private String couponId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.coupon_paid
     *
     * @mbg.generated
     */
    private BigDecimal couponPaid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.money_paid
     *
     * @mbg.generated
     */
    private BigDecimal moneyPaid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.pay_amount
     *
     * @mbg.generated
     */
    private BigDecimal payAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.add_time
     *
     * @mbg.generated
     */
    private Date addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.confirm_tmie
     *
     * @mbg.generated
     */
    private Date confirmTmie;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_order.pay_time
     *
     * @mbg.generated
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_order
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.order_id
     *
     * @return the value of trade_order.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.order_id
     *
     * @param orderId the value for trade_order.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.user_id
     *
     * @return the value of trade_order.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.user_id
     *
     * @param userId the value for trade_order.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.order_status
     *
     * @return the value of trade_order.order_status
     *
     * @mbg.generated
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.order_status
     *
     * @param orderStatus the value for trade_order.order_status
     *
     * @mbg.generated
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.pay_status
     *
     * @return the value of trade_order.pay_status
     *
     * @mbg.generated
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.pay_status
     *
     * @param payStatus the value for trade_order.pay_status
     *
     * @mbg.generated
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.shipping_status
     *
     * @return the value of trade_order.shipping_status
     *
     * @mbg.generated
     */
    public String getShippingStatus() {
        return shippingStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.shipping_status
     *
     * @param shippingStatus the value for trade_order.shipping_status
     *
     * @mbg.generated
     */
    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus == null ? null : shippingStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.addres
     *
     * @return the value of trade_order.addres
     *
     * @mbg.generated
     */
    public String getAddres() {
        return addres;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.addres
     *
     * @param addres the value for trade_order.addres
     *
     * @mbg.generated
     */
    public void setAddres(String addres) {
        this.addres = addres == null ? null : addres.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.consignee
     *
     * @return the value of trade_order.consignee
     *
     * @mbg.generated
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.consignee
     *
     * @param consignee the value for trade_order.consignee
     *
     * @mbg.generated
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.goods_id
     *
     * @return the value of trade_order.goods_id
     *
     * @mbg.generated
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.goods_id
     *
     * @param goodsId the value for trade_order.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.goods_number
     *
     * @return the value of trade_order.goods_number
     *
     * @mbg.generated
     */
    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.goods_number
     *
     * @param goodsNumber the value for trade_order.goods_number
     *
     * @mbg.generated
     */
    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.goods_price
     *
     * @return the value of trade_order.goods_price
     *
     * @mbg.generated
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.goods_price
     *
     * @param goodsPrice the value for trade_order.goods_price
     *
     * @mbg.generated
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.goods_amount
     *
     * @return the value of trade_order.goods_amount
     *
     * @mbg.generated
     */
    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.goods_amount
     *
     * @param goodsAmount the value for trade_order.goods_amount
     *
     * @mbg.generated
     */
    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.shipping_fee
     *
     * @return the value of trade_order.shipping_fee
     *
     * @mbg.generated
     */
    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.shipping_fee
     *
     * @param shippingFee the value for trade_order.shipping_fee
     *
     * @mbg.generated
     */
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.order_amoumt
     *
     * @return the value of trade_order.order_amoumt
     *
     * @mbg.generated
     */
    public BigDecimal getOrderAmoumt() {
        return orderAmoumt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.order_amoumt
     *
     * @param orderAmoumt the value for trade_order.order_amoumt
     *
     * @mbg.generated
     */
    public void setOrderAmoumt(BigDecimal orderAmoumt) {
        this.orderAmoumt = orderAmoumt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.coupon_id
     *
     * @return the value of trade_order.coupon_id
     *
     * @mbg.generated
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.coupon_id
     *
     * @param couponId the value for trade_order.coupon_id
     *
     * @mbg.generated
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.coupon_paid
     *
     * @return the value of trade_order.coupon_paid
     *
     * @mbg.generated
     */
    public BigDecimal getCouponPaid() {
        return couponPaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.coupon_paid
     *
     * @param couponPaid the value for trade_order.coupon_paid
     *
     * @mbg.generated
     */
    public void setCouponPaid(BigDecimal couponPaid) {
        this.couponPaid = couponPaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.money_paid
     *
     * @return the value of trade_order.money_paid
     *
     * @mbg.generated
     */
    public BigDecimal getMoneyPaid() {
        return moneyPaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.money_paid
     *
     * @param moneyPaid the value for trade_order.money_paid
     *
     * @mbg.generated
     */
    public void setMoneyPaid(BigDecimal moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.pay_amount
     *
     * @return the value of trade_order.pay_amount
     *
     * @mbg.generated
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.pay_amount
     *
     * @param payAmount the value for trade_order.pay_amount
     *
     * @mbg.generated
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.add_time
     *
     * @return the value of trade_order.add_time
     *
     * @mbg.generated
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.add_time
     *
     * @param addTime the value for trade_order.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.confirm_tmie
     *
     * @return the value of trade_order.confirm_tmie
     *
     * @mbg.generated
     */
    public Date getConfirmTmie() {
        return confirmTmie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.confirm_tmie
     *
     * @param confirmTmie the value for trade_order.confirm_tmie
     *
     * @mbg.generated
     */
    public void setConfirmTmie(Date confirmTmie) {
        this.confirmTmie = confirmTmie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.pay_time
     *
     * @return the value of trade_order.pay_time
     *
     * @mbg.generated
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.pay_time
     *
     * @param payTime the value for trade_order.pay_time
     *
     * @mbg.generated
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", shippingStatus=").append(shippingStatus);
        sb.append(", addres=").append(addres);
        sb.append(", consignee=").append(consignee);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsAmount=").append(goodsAmount);
        sb.append(", shippingFee=").append(shippingFee);
        sb.append(", orderAmoumt=").append(orderAmoumt);
        sb.append(", couponId=").append(couponId);
        sb.append(", couponPaid=").append(couponPaid);
        sb.append(", moneyPaid=").append(moneyPaid);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", addTime=").append(addTime);
        sb.append(", confirmTmie=").append(confirmTmie);
        sb.append(", payTime=").append(payTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated
     */
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
        TradeOrder other = (TradeOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getShippingStatus() == null ? other.getShippingStatus() == null : this.getShippingStatus().equals(other.getShippingStatus()))
            && (this.getAddres() == null ? other.getAddres() == null : this.getAddres().equals(other.getAddres()))
            && (this.getConsignee() == null ? other.getConsignee() == null : this.getConsignee().equals(other.getConsignee()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsNumber() == null ? other.getGoodsNumber() == null : this.getGoodsNumber().equals(other.getGoodsNumber()))
            && (this.getGoodsPrice() == null ? other.getGoodsPrice() == null : this.getGoodsPrice().equals(other.getGoodsPrice()))
            && (this.getGoodsAmount() == null ? other.getGoodsAmount() == null : this.getGoodsAmount().equals(other.getGoodsAmount()))
            && (this.getShippingFee() == null ? other.getShippingFee() == null : this.getShippingFee().equals(other.getShippingFee()))
            && (this.getOrderAmoumt() == null ? other.getOrderAmoumt() == null : this.getOrderAmoumt().equals(other.getOrderAmoumt()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getCouponPaid() == null ? other.getCouponPaid() == null : this.getCouponPaid().equals(other.getCouponPaid()))
            && (this.getMoneyPaid() == null ? other.getMoneyPaid() == null : this.getMoneyPaid().equals(other.getMoneyPaid()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getConfirmTmie() == null ? other.getConfirmTmie() == null : this.getConfirmTmie().equals(other.getConfirmTmie()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getShippingStatus() == null) ? 0 : getShippingStatus().hashCode());
        result = prime * result + ((getAddres() == null) ? 0 : getAddres().hashCode());
        result = prime * result + ((getConsignee() == null) ? 0 : getConsignee().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsNumber() == null) ? 0 : getGoodsNumber().hashCode());
        result = prime * result + ((getGoodsPrice() == null) ? 0 : getGoodsPrice().hashCode());
        result = prime * result + ((getGoodsAmount() == null) ? 0 : getGoodsAmount().hashCode());
        result = prime * result + ((getShippingFee() == null) ? 0 : getShippingFee().hashCode());
        result = prime * result + ((getOrderAmoumt() == null) ? 0 : getOrderAmoumt().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getCouponPaid() == null) ? 0 : getCouponPaid().hashCode());
        result = prime * result + ((getMoneyPaid() == null) ? 0 : getMoneyPaid().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getConfirmTmie() == null) ? 0 : getConfirmTmie().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        return result;
    }
}