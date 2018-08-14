package com.ace.trade.goods.mapper;

import com.ace.trade.goods.entity.TradeGoodsNumberLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeGoodsNumberLogMapper {

    int insert(TradeGoodsNumberLog record);

    List<TradeGoodsNumberLog> selectAll();

    TradeGoodsNumberLog findById(TradeGoodsNumberLog record);
}