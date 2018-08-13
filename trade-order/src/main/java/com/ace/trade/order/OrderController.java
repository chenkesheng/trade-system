package com.ace.trade.order;

import com.ace.trade.order.request.ConfirmOrderReq;
import com.ace.trade.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cks
 * @Date: Created by 15:43 2018/8/13
 * @Package: com.ace.trade.order
 * @Description:
 */
@RestController("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping(value = "/confirmOrder")
    public void confirmOrder(ConfirmOrderReq dto) {
        orderService.confirmOrder(dto);
    }
}
