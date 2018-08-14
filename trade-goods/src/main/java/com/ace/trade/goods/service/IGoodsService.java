package com.ace.trade.goods.service;

import com.ace.trade.goods.request.AddGoodsNumReq;
import com.ace.trade.goods.request.QueryGoodsReq;
import com.ace.trade.goods.request.ReduceGoodsNumReq;
import com.ace.trade.goods.entity.TradeGoods;
import com.ace.trade.goods.response.AddGoodsNumRes;
import com.ace.trade.goods.response.ReduceGoodsNumRes;

/**
 * @Author: cks
 * @Date: Created by 15:32 2018/8/13
 * @Package: com.ace.trade.goods.service
 * @Description:
 */
public interface IGoodsService {

    TradeGoods queryGoods(QueryGoodsReq dto);

    ReduceGoodsNumRes reduceGoodsNumber(ReduceGoodsNumReq dto);

    AddGoodsNumRes addGoodsNumber(AddGoodsNumReq dto);
}
