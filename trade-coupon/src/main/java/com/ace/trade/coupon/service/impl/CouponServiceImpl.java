package com.ace.trade.coupon.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.coupon.entity.TradeCoupon;
import com.ace.trade.coupon.mapper.TradeCouponMapper;
import com.ace.trade.coupon.request.ChangeCouponStatusReq;
import com.ace.trade.coupon.request.QueryCouponReq;
import com.ace.trade.coupon.response.ChangeCouponStatusRes;
import com.ace.trade.coupon.service.ICouponService;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: cks
 * @Date: Created by 16:46 2018/8/13
 * @Package: com.ace.trade.coupon.service.impl
 * @Description:
 */
@Service(interfaceClass = ICouponService.class)
public class CouponServiceImpl implements ICouponService {

    @Autowired
    private TradeCouponMapper tradeCouponMapper;

    @Override
    public TradeCoupon findCoupon(QueryCouponReq dto) {
        try {
            if (dto == null || StringUtils.isEmpty(dto.getCouponId())) {
                throw new Exception("请求参数不正确，优惠券编号为空");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return tradeCouponMapper.selectByPrimaryKey(dto.getCouponId());
    }

    @Override
    public ChangeCouponStatusRes changeStatus(ChangeCouponStatusReq dto) {
        ChangeCouponStatusRes changeCouponStatusRes = new ChangeCouponStatusRes();
        changeCouponStatusRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getCode());
        changeCouponStatusRes.setResultInfo(TradeEnums.ResultEnum.SUCCESS.getDesc());
        try {
            if (dto == null || StringUtils.isEmpty(dto.getCouponId())){
                throw new Exception("请求参数不正确，优惠券编号为空");
            }
            TradeCoupon tradeCoupon = new TradeCoupon();
            tradeCoupon.setCouponId(dto.getCouponId());
            tradeCoupon.setOrderId(dto.getOrderId());
            //使用优惠券
            if (dto.getIsUsed().equals(TradeEnums.YesOrNoEnum.YES.getCode())){
                int i = tradeCouponMapper.useCoupon(tradeCoupon);
                if (i <= 0){
                    throw new Exception("使用该优惠券失败");
                }

            }else if (dto.getIsUsed().equals(TradeEnums.YesOrNoEnum.NO.getCode())){
                int i = tradeCouponMapper.unUseCoupon(tradeCoupon);

            }
        }catch (Exception e) {
            changeCouponStatusRes.setResultCode(TradeEnums.ResultEnum.FAIL.getCode());
            changeCouponStatusRes.setResultInfo(e.getMessage());
        }
        return changeCouponStatusRes;
    }
}
