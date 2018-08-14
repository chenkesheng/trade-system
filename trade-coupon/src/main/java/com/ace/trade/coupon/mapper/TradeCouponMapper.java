package com.ace.trade.coupon.mapper;

import com.ace.trade.coupon.entity.TradeCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeCouponMapper {

    int deleteByPrimaryKey(String couponId);

    int insert(TradeCoupon record);

    TradeCoupon selectByPrimaryKey(String couponId);

    List<TradeCoupon> selectAll();

    int updateByPrimaryKey(TradeCoupon record);

    int useCoupon(TradeCoupon tradeCoupon);

    int unUseCoupon(TradeCoupon tradeCoupon);
}