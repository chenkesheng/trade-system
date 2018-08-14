package com.ace.trade.ace.mapper;

import com.ace.trade.ace.entity.TradePay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradePayMapper {
    int deleteByPrimaryKey(String payId);

    int insert(TradePay record);

    TradePay selectByPrimaryKey(String payId);

    List<TradePay> selectAll();

    int updateByPrimaryKey(TradePay record);

    TradePay queryPay(TradePay tradePay);
}