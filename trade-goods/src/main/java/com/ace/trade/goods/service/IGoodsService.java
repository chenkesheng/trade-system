package com.ace.trade.goods.service;

import com.ace.trade.goods.dto.QueryGoodsDto;
import com.ace.trade.goods.dto.ReduceGoodsNumDto;
import com.ace.trade.goods.entity.TradeGoods;

/**
 * @Author: cks
 * @Date: Created by 15:32 2018/8/13
 * @Package: com.ace.trade.goods.service
 * @Description:
 */
public interface IGoodsService {

    TradeGoods queryGoods(QueryGoodsDto dto);

    void reduceGoodsNumber(ReduceGoodsNumDto dto);
}
