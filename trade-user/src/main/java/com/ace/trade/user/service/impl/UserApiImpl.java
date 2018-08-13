package com.ace.trade.user.service.impl;

import com.ace.trade.user.entity.TradeUser;
import com.ace.trade.user.mapper.TradeUserMapper;
import com.ace.trade.user.request.ChangeUserMoneyReq;
import com.ace.trade.user.request.QueryUserReq;
import com.ace.trade.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: cks
 * @Date: Created by 20:06 2018/8/12
 * @Package: com.ace.trade.user.service
 * @Description:
 */
@Service
public class UserApiImpl implements IUserService {

    @Autowired
    private TradeUserMapper tradeUserMapper;

    public TradeUser findUserById(QueryUserReq dto) {
        return tradeUserMapper.selectByPrimaryKey(dto.getUserId());
    }

    public void insert(TradeUser tradeUser) {
        tradeUserMapper.insert(tradeUser);
    }

    @Override
    public TradeUser changeUserMoney(ChangeUserMoneyReq dto) {
        return null;
    }
}
