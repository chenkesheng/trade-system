package com.ace.trade.order.service;

import com.ace.trade.order.request.ConfirmOrderReq;
import com.ace.trade.order.response.ConfirmOrderRes;

/**
 * @Author: cks
 * @Date: Created by 11:36 2018/8/13
 * @Package: com.ace.trade.order.service
 * @Description:
 */
public interface IOrderService {

    ConfirmOrderRes confirmOrder(ConfirmOrderReq dto);
}
