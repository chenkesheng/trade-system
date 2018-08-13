package com.ace.trade.order.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.exception.OrderException;
import com.ace.trade.common.util.IDGenarator;
import com.ace.trade.coupon.entity.TradeCoupon;
import com.ace.trade.coupon.request.QueryCouponReq;
import com.ace.trade.coupon.service.ICouponService;
import com.ace.trade.goods.dto.QueryGoodsDto;
import com.ace.trade.goods.entity.TradeGoods;
import com.ace.trade.goods.service.IGoodsService;
import com.ace.trade.order.request.ConfirmOrderReq;
import com.ace.trade.order.entity.TradeOrder;
import com.ace.trade.order.mapper.TradeOrderMapper;
import com.ace.trade.order.response.ConfirmOrderRes;
import com.ace.trade.order.service.IOrderService;
import com.ace.trade.user.entity.TradeUser;
import com.ace.trade.user.request.QueryUserReq;
import com.ace.trade.user.service.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: cks
 * @Date: Created by 11:37 2018/8/13
 * @Package: com.ace.trade.order.service.impl
 * @Description:
 */
@Service(interfaceClass = IOrderService.class)
public class OrderServiceImpl implements IOrderService {


    @Reference
    private IGoodsService goodsService;

    @Reference
    private ICouponService couponService;

    @Reference
    private IUserService userService;

    @Autowired
    private TradeOrderMapper tradeOrderMapper;

    @Override
    public ConfirmOrderRes confirmOrder(ConfirmOrderReq dto) {
        ConfirmOrderRes confirmOrderRes = new ConfirmOrderRes();
        confirmOrderRes.setCode(TradeEnums.ResultEnum.SUCCESS.getCode());
        try {
            QueryGoodsDto queryGoodsDto = new QueryGoodsDto();
            queryGoodsDto.setGoodsId(dto.getGoodsId());

            TradeGoods tradeGoods = goodsService.queryGoods(queryGoodsDto);
            //1.检查校验
            checkConfirmOrderDto(dto, tradeGoods);
            //2.创建不可见订单
            saveNoConfirmOrder(dto);
            //3.调用远程服务,扣优惠券，扣库存，扣余额。如果调用成功 ->就更改订单状态为可见， 失败 ->发送mq消息，进行取消订单
        } catch (Exception e) {
            confirmOrderRes.setCode(TradeEnums.ResultEnum.FAIL.getCode());
            confirmOrderRes.setInfo(e.getMessage());
        }
        return confirmOrderRes;
    }

    private void checkConfirmOrderDto(ConfirmOrderReq dto, TradeGoods tradeGoods) {

        if (dto == null) {
            throw new OrderException("下单信息不能为空.");
        }

        if (dto.getUserId() == null) {
            throw new OrderException("会员账号不能为空");
        }

        if (dto.getGoodsId() == null) {
            throw new OrderException("商品编号不能为空");
        }
        if (dto.getGoodNumber() == null || dto.getGoodNumber() <= 0) {
            throw new OrderException("购买数量不能小于0");
        }
        if (StringUtils.isEmpty(dto.getAddress())) {
            throw new OrderException("收货地址不能为空");
        }
        if (StringUtils.isEmpty(dto.getAddress())) {
            throw new OrderException("收货地址不能为空");
        }
        if (tradeGoods == null) {
            throw new OrderException("未查询到该商品[" + dto.getGoodsId() + "]");
        }

        if (tradeGoods.getGoodsNumber() < dto.getGoodNumber()) {
            throw new OrderException("库存不足");
        }
        if (tradeGoods.getGoodsPrice().compareTo(dto.getGoodsPrice()) != 0) {
            throw new OrderException("当前商品价格有变化，请重新下单");
        }

        if (dto.getShippingFee() == null) {
            dto.setShippingFee(BigDecimal.ZERO);
        }

        if (dto.getOrderAmount() == null) {
            dto.setOrderAmount(BigDecimal.ZERO);
        }
    }

    private void saveNoConfirmOrder(ConfirmOrderReq dto) throws Exception {
        TradeOrder tradeOrder = new TradeOrder();

        String orderId = IDGenarator.generatorUUID();
        tradeOrder.setOrderId(orderId);
        tradeOrder.setUserId(dto.getUserId());
        tradeOrder.setOrderStatus(TradeEnums.OrderStatusEnum.NO_CONFIRM.getStatusCode());
        tradeOrder.setShippingStatus(TradeEnums.ShippingStatusEnum.NO_SHIP.getStatusCode());
        tradeOrder.setAddres(dto.getAddress());
        tradeOrder.setConsignee(dto.getConsignee());
        tradeOrder.setGoodsId(dto.getGoodsId());
        tradeOrder.setGoodsNumber(dto.getGoodNumber());
        tradeOrder.setGoodsPrice(dto.getGoodsPrice());
        BigDecimal goodsAmount = dto.getGoodsPrice().multiply(new BigDecimal(dto.getGoodNumber()));
        tradeOrder.setGoodsAmount(goodsAmount);
        BigDecimal shippingFee = calculateShippingFee(goodsAmount);
        if (dto.getShippingFee().compareTo(shippingFee) != 0) {
            throw new OrderException("快递费用不正确");
        }
        tradeOrder.setShippingFee(shippingFee);
        BigDecimal orderAmount = goodsAmount.add(shippingFee);
        if (dto.getOrderAmount().compareTo(orderAmount) != 0) {
            throw new OrderException("订单总价异常，请重新下单");
        }
        tradeOrder.setOrderAmoumt(orderAmount);
        String couponId = dto.getCouponId();
        //如果优惠券不为空
        if (StringUtils.isEmpty(couponId)) {
            QueryCouponReq queryCouponReq = new QueryCouponReq();
            queryCouponReq.setCouponId(couponId);
            TradeCoupon tradeCoupon = couponService.findCoupon(queryCouponReq);
            if (tradeCoupon == null) {
                throw new OrderException("优惠券非法");
            }
            if (!TradeEnums.YesOrNoEnum.NO.getCode().equals(tradeCoupon.getIsUsed())) {
                throw new OrderException("优惠券已使用");
            }
            tradeOrder.setCouponId(couponId);
            tradeOrder.setCouponPaid(tradeCoupon.getCouponPrice());
        }else {
            tradeOrder.setCouponPaid(BigDecimal.ZERO);
        }

        //余额支付
        if (dto.getMoneyPaid() != null) {
            int result = dto.getMoneyPaid().compareTo(BigDecimal.ZERO);
            if (result == -1) {
                throw new OrderException("余额金额非法");
            }
            if (result == 1) {
                QueryUserReq queryUserReq = new QueryUserReq();
                queryUserReq.setUserId(dto.getUserId());
                TradeUser tradeUser = userService.findUserById(queryUserReq);
                if (tradeUser == null) {
                    throw new Exception("用户非法");
                }

                if (tradeUser.getUserMoney().compareTo(dto.getMoneyPaid()) == -1) {
                    throw new OrderException("余额不足");
                }
                tradeOrder.setMoneyPaid(dto.getMoneyPaid());
            }
        } else {
            tradeOrder.setMoneyPaid(BigDecimal.ZERO);
        }

        BigDecimal payAmount = orderAmount.subtract(tradeOrder.getMoneyPaid()).subtract(tradeOrder.getCouponPaid());

        tradeOrder.setPayAmount(payAmount);

        tradeOrder.setAddTime(new Date());

        int result = tradeOrderMapper.insert(tradeOrder);
        if (result != 1) {
            throw new OrderException("保存订单失败");
        }
    }

    private BigDecimal calculateShippingFee(BigDecimal goodsAmount) {
        if (goodsAmount.doubleValue() > 100.00) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal("10");
    }
}
