package com.ace.trade.user.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.exception.OrderException;
import com.ace.trade.user.entity.TradeUser;
import com.ace.trade.user.entity.TradeUserMoneyLog;
import com.ace.trade.user.mapper.TradeUserMapper;
import com.ace.trade.user.mapper.TradeUserMoneyLogMapper;
import com.ace.trade.user.request.ChangeUserMoneyReq;
import com.ace.trade.user.request.QueryUserReq;
import com.ace.trade.user.response.ChangeUserMoneyRes;
import com.ace.trade.user.response.QueryUserRes;
import com.ace.trade.user.service.IUserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: cks
 * @Date: Created by 20:06 2018/8/12
 * @Package: com.ace.trade.user.service
 * @Description:
 */
@Service(interfaceClass = IUserService.class)
public class UserApiImpl implements IUserService {

    @Autowired
    private TradeUserMapper tradeUserMapper;
    @Autowired
    private TradeUserMoneyLogMapper tradeUserMoneyLogMapper;

    public TradeUser findUserById(QueryUserReq dto) {
        return tradeUserMapper.selectByPrimaryKey(dto.getUserId());
    }

    public void insert(TradeUser tradeUser) {
        tradeUserMapper.insert(tradeUser);
    }

    @Transactional
    @Override
    public ChangeUserMoneyRes changeUserMoney(ChangeUserMoneyReq dto) {
        ChangeUserMoneyRes changeUserMoneyRes = new ChangeUserMoneyRes();
        changeUserMoneyRes.setResultCode(TradeEnums.ResultEnum.SUCCESS.getCode());
        changeUserMoneyRes.setResultInfo(TradeEnums.ResultEnum.SUCCESS.getDesc());

        if (dto == null || dto.getUserId() == null || dto.getUserMoney() == null) {
            throw new RuntimeException("请求参数不正确");
        }
        if (dto.getUserMoney().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("金额不能小于0");
        }

        TradeUserMoneyLog tradeUserMoneyLog = new TradeUserMoneyLog();
        tradeUserMoneyLog.setOrderId(dto.getOrderId());
        tradeUserMoneyLog.setUserId(dto.getUserId());
        tradeUserMoneyLog.setUserMoney(dto.getUserMoney());
        tradeUserMoneyLog.setCreateTime(new Date());
        tradeUserMoneyLog.setMoneyLogType(Integer.valueOf(dto.getMoneyLogType()));

        TradeUser tradeUser = new TradeUser();
        tradeUser.setUserId(dto.getUserId());
        tradeUser.setUserMoney(dto.getUserMoney());

        //查询是否有付款记录
        TradeUserMoneyLog userMoneyLog = tradeUserMoneyLogMapper.queryTradeUserMoneyLog(dto.getOrderId(), dto.getUserId(),
                TradeEnums.UserMoneyLogTypeEnum.PAID.getCode());

        //订单付款
        if (dto.getMoneyLogType().equals(TradeEnums.UserMoneyLogTypeEnum.PAID.getCode())) {
            if (userMoneyLog != null) {
                throw new RuntimeException("已经付过款了，不能再付款");
            }
            tradeUserMapper.reduceUserMoney(tradeUser);
        }
        //订单退款
        if (dto.getMoneyLogType().equals(TradeEnums.UserMoneyLogTypeEnum.REFUND.getCode())) {
            if (userMoneyLog == null) {
                throw new RuntimeException("没有付款信息，不能退款");
            }
            //防止多次退款
            TradeUserMoneyLog log = tradeUserMoneyLogMapper.queryTradeUserMoneyLog(dto.getOrderId(), dto.getUserId(),
                    TradeEnums.UserMoneyLogTypeEnum.REFUND.getCode());
            if (log != null) {
                throw new RuntimeException("该订单已经退过款了,不能退款");
            }
            tradeUserMapper.addUserMoney(tradeUser);
        }
        tradeUserMoneyLogMapper.insert(tradeUserMoneyLog);
        return changeUserMoneyRes;
    }
}
