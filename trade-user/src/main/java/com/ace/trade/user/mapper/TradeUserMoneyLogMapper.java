package com.ace.trade.user.mapper;

import com.ace.trade.user.entity.TradeUserMoneyLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TradeUserMoneyLogMapper {

    int insert(TradeUserMoneyLog record);

    List<TradeUserMoneyLog> selectAll();

    TradeUserMoneyLog queryTradeUserMoneyLog(@Param(value = "orderId") String orderId,
                                             @Param("userId") Integer userId, @Param("moneyLogType") String moneyLogType);
}