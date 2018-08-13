package com.ace.trade.coupon.service;

import com.ace.trade.coupon.request.ChangeCouponStatusDto;
import com.ace.trade.coupon.entity.TradeCoupon;
import com.ace.trade.coupon.request.QueryCouponReq;

/**
 * @Author: cks
 * @Date: Created by 11:48 2018/8/13
 * @Package: com.ace.trade.coupon.service
 * @Description:
 */
public interface ICouponService {

    TradeCoupon findCoupon(QueryCouponReq dto);

    void changeStatus(ChangeCouponStatusDto dto);
}
