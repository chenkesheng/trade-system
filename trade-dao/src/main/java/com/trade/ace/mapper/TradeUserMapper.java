package com.trade.ace.mapper;

import com.trade.ace.entity.TradeUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeUserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(TradeUser record);

    TradeUser selectByPrimaryKey(Integer userId);

    List<TradeUser> selectAll();

    int updateByPrimaryKey(TradeUser record);
}