package com.ace.trade.coupon.service;

import com.ace.trade.coupon.request.ChangeCouponStatusReq;
import com.ace.trade.coupon.entity.TradeCoupon;
import com.ace.trade.coupon.request.QueryCouponReq;
import com.ace.trade.coupon.response.ChangeCouponStatusRes;

/**
 * @Author: cks
 * @Date: Created by 11:48 2018/8/13
 * @Package: com.ace.trade.coupon.service
 * @Description:
 */
public interface ICouponService {

    TradeCoupon findCoupon(QueryCouponReq dto);

    ChangeCouponStatusRes changeStatus(ChangeCouponStatusReq dto);
}
