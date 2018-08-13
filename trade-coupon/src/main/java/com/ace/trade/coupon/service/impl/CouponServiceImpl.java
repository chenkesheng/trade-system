package com.ace.trade.coupon.service.impl;

import com.ace.trade.coupon.entity.TradeCoupon;
import com.ace.trade.coupon.request.ChangeCouponStatusReq;
import com.ace.trade.coupon.request.QueryCouponReq;
import com.ace.trade.coupon.response.ChangeCouponStatusRes;
import com.ace.trade.coupon.service.ICouponService;

/**
 * @Author: cks
 * @Date: Created by 16:46 2018/8/13
 * @Package: com.ace.trade.coupon.service.impl
 * @Description:
 */
public class CouponServiceImpl implements ICouponService {
    @Override
    public TradeCoupon findCoupon(QueryCouponReq dto) {
        return null;
    }

    @Override
    public ChangeCouponStatusRes changeStatus(ChangeCouponStatusReq dto) {
        return null;
    }
}
