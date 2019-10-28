package com.ace.trade.goods.mapper;

import com.ace.trade.goods.entity.TradeMqConsumerLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: cks
 * @Date: Created by 15:19 2018/8/14
 * @Package: com.ace.trade.goods.mapper
 * @Description:
 */
@Mapper
public interface TradeMqConsumerLogMapper {
    List<TradeMqConsumerLog> findAll();

    TradeMqConsumerLog findById(TradeMqConsumerLog record);

    int insert(TradeMqConsumerLog record);

    int updatePrimaryKeySelective(TradeMqConsumerLog record);

    int updateByKeySelective(TradeMqConsumerLog record);
}
