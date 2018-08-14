package com.ace.trade.ace.service;

import com.ace.trade.ace.request.CallbackPaymentReq;
import com.ace.trade.ace.request.CreatePaymentReq;
import com.ace.trade.ace.response.CallbackPaymentRes;
import com.ace.trade.ace.response.CreatePaymentRes;

/**
 * @Author: cks
 * @Date: Created by 14:59 2018/8/13
 * @Package: com.ace.trade.ace.service
 * @Description:
 */
public interface IPayService {

    /**
     * 创建支付单
     *
     * @param dto
     * @return
     */
    CreatePaymentRes createPayment(CreatePaymentReq dto);

    /**
     * 支付回调
     *
     * @param dto
     * @return
     */
    CallbackPaymentRes callbackPayment(CallbackPaymentReq dto);
}
