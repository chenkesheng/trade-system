package com.ace.trade.user.controller;

import com.ace.trade.user.entity.TradeUser;
import com.ace.trade.user.request.QueryUserReq;
import com.ace.trade.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cks
 * @Date: Created by 20:37 2018/8/12
 * @Package: com.ace.trade.user.controller
 * @Description:
 */
@RestController("/")
public class TradeUserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "add")
    public Map<String,Object> insert(TradeUser tradeUser){
        tradeUser.setUserName("张三");
        tradeUser.setUserPassword("123456");
        userService.insert(tradeUser);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", 200);
        return map ;

    }

    @GetMapping(value = "findById")
    public TradeUser findById(QueryUserReq dto){

        return userService.findUserById(dto);
    }
}
