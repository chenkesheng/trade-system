package com.ace.trade.order.mapper;

import com.ace.trade.order.entity.TradeOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(TradeOrder record);

    TradeOrder selectByPrimaryKey(String orderId);

    List<TradeOrder> selectAll();

    int updateByPrimaryKey(TradeOrder record);
}