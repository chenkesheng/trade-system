package com.ace.trade.user.service;


import com.ace.trade.user.request.ChangeUserMoneyReq;
import com.ace.trade.user.entity.TradeUser;
import com.ace.trade.user.request.QueryUserReq;
import com.ace.trade.user.response.ChangeUserMoneyRes;

/**
 * @Author: cks
 * @Date: Created by 20:07 2018/8/12
 * @Package: com.ace.trade.user.service
 * @Description:
 */
public interface IUserService {

    TradeUser findUserById(QueryUserReq dto);

    void insert(TradeUser tradeUser);

    ChangeUserMoneyRes changeUserMoney(ChangeUserMoneyReq dto);
}
