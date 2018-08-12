package com.ace.trade.user.controller;

import com.ace.trade.user.entity.TradeUser;
import com.ace.trade.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cks
 * @Date: Created by 20:37 2018/8/12
 * @Package: com.ace.trade.user.controller
 * @Description:
 */
@RestController
@RequestMapping("/")
public class TradeUserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "insert")
    public void insert(TradeUser tradeUser){
        tradeUser.setUserName("张三");
        tradeUser.setUserPassword("123456");
        userService.insert(tradeUser);
    }

    @GetMapping(value = "findById")
    public TradeUser findById(Integer id){
        return userService.findUserById(id);
    }
}
