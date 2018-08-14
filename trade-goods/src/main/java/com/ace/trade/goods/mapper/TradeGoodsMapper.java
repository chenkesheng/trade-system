package com.ace.trade.goods.mapper;

import com.ace.trade.goods.entity.TradeGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeGoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(TradeGoods record);

    TradeGoods selectByPrimaryKey(Integer goodsId);

    List<TradeGoods> selectAll();

    int updateByPrimaryKey(TradeGoods record);

    int reduceGoodsNumber(TradeGoods tradeGoods);

    int addGoodsNumber(TradeGoods tradeGoods);
}