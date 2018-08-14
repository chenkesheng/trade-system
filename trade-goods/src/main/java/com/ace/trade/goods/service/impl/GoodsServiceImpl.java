package com.ace.trade.goods.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.goods.entity.TradeGoods;
import com.ace.trade.goods.entity.TradeGoodsNumberLog;
import com.ace.trade.goods.mapper.TradeGoodsMapper;
import com.ace.trade.goods.mapper.TradeGoodsNumberLogMapper;
import com.ace.trade.goods.request.AddGoodsNumReq;
import com.ace.trade.goods.request.QueryGoodsReq;
import com.ace.trade.goods.request.ReduceGoodsNumReq;
import com.ace.trade.goods.response.AddGoodsNumRes;
import com.ace.trade.goods.response.ReduceGoodsNumRes;
import com.ace.trade.goods.service.IGoodsService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: cks
 * @Date: Created by 15:32 2018/8/13
 * @Package: com.ace.trade.goods.service.impl
 * @Description:
 */
@Service(interfaceClass = IGoodsService.class)
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private TradeGoodsMapper tradeGoodsMapper;
    @Autowired
    private TradeGoodsNumberLogMapper tradeGoodsNumberLogMapper;

    @Override
    public TradeGoods queryGoods(QueryGoodsReq dto) {
        try {
            if (dto == null || dto.getGoodsId() == null) {
                throw new Exception("查询商品信息id不正确");
            }
            TradeGoods tradeGoods = tradeGoodsMapper.selectByPrimaryKey(dto.getGoodsId());
            if (tradeGoods == null) {
                throw new Exception("未查询到商品");
            }
            return tradeGoods;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 减少库存
     *
     * @param dto
     * @return
     */
    @Transactional
    @Override
    public ReduceGoodsNumRes reduceGoodsNumber(ReduceGoodsNumReq dto) {
        ReduceGoodsNumRes reduceGoodsNumRes = new ReduceGoodsNumRes();
        reduceGoodsNumRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getCode());
        reduceGoodsNumRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getDesc());
        try {
            if (dto == null || dto.getGoodsId() == null || dto.getGoodsNumber() == null
                    || dto.getGoodsNumber() <= 0) {
                throw new RuntimeException("扣减库存参数不正确");
            }
            TradeGoods tradeGoods = new TradeGoods();
            tradeGoods.setGoodsId(dto.getGoodsId());
            tradeGoods.setGoodsNumber(dto.getGoodsNumber());
            int i = tradeGoodsMapper.reduceGoodsNumber(tradeGoods);
            if (i <= 0) {
                throw new RuntimeException("扣减库存失败");
            }
            TradeGoodsNumberLog tradeGoodsNumberLog = new TradeGoodsNumberLog();
            tradeGoodsNumberLog.setGoodsId(dto.getGoodsId());
            tradeGoodsNumberLog.setGoodsNumber(dto.getGoodsNumber());
            tradeGoodsNumberLog.setOrderId(dto.getOrderId());
            tradeGoodsNumberLog.setLogTime(new Date());
            tradeGoodsNumberLogMapper.insert(tradeGoodsNumberLog);
        } catch (Exception e) {
            reduceGoodsNumRes.setResultCode(TradeEnums.ResultEnum.FAIL.getCode());
            reduceGoodsNumRes.setResultCode(e.getMessage());
            return reduceGoodsNumRes;
        }
        return reduceGoodsNumRes;
    }

    @Transactional
    @Override
    public AddGoodsNumRes addGoodsNumber(AddGoodsNumReq dto) {
        AddGoodsNumRes addGoodsNumRes = new AddGoodsNumRes();
        addGoodsNumRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getCode());
        addGoodsNumRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getDesc());
        try {
            if (dto == null || dto.getGoodsId() == null || dto.getGoodsNumber() == null
                    || dto.getGoodsNumber() <= 0) {
                throw new RuntimeException("增加库存请求参数不正确");
            }
            if (dto.getOrderId() != null) {
                TradeGoodsNumberLog tradeGoodsNumberLog = new TradeGoodsNumberLog();
                tradeGoodsNumberLog.setOrderId(dto.getOrderId());
                tradeGoodsNumberLog.setGoodsId(dto.getGoodsId());
                TradeGoodsNumberLog goodsNumberLog = tradeGoodsNumberLogMapper.findById(tradeGoodsNumberLog);
                if (goodsNumberLog == null) {
                    throw new RuntimeException("未找到扣减库存记录");
                }
            }
            TradeGoods tradeGoods = new TradeGoods();
            tradeGoods.setGoodsId(dto.getGoodsId());
            tradeGoods.setGoodsNumber(dto.getGoodsNumber());
            int result = tradeGoodsMapper.addGoodsNumber(tradeGoods);
            if (result <= 0) {
                throw new RuntimeException("增加库存失败");
            }
        } catch (Exception e) {
            addGoodsNumRes.setResultCode(TradeEnums.ResultEnum.FAIL.getCode());
            addGoodsNumRes.setResultCode(e.getMessage());
            return addGoodsNumRes;
        }
        return addGoodsNumRes;
    }
}
