package com.ace.trade.user.mapper;

import com.ace.trade.user.entity.TradeUserMoneyLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeUserMoneyLogMapper {

    int insert(TradeUserMoneyLog record);

    List<TradeUserMoneyLog> selectAll();
}