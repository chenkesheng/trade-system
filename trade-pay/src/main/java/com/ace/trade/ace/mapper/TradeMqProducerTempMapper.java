package com.ace.trade.ace.mapper;

import com.ace.trade.ace.entity.TradeMqProducerTemp;

/**
 * @Author: cks
 * @Date: Created by 16:59 2018/8/14
 * @Package: com.ace.trade.ace.mapper
 * @Description:
 */
public interface TradeMqProducerTempMapper {
    int insert(TradeMqProducerTemp record);

    int delete(String id);
}
