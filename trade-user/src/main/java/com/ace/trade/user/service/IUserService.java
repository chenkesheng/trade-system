package com.ace.trade.user.service;


import com.ace.trade.user.entity.TradeUser;

/**
 * @Author: cks
 * @Date: Created by 20:07 2018/8/12
 * @Package: com.ace.trade.user.service
 * @Description:
 */
public interface IUserService {

    TradeUser findUserById(Integer id);

    void insert(TradeUser tradeUser);
}
