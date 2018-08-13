package com.ace.trade.common.exception;

/**
 * @Author: cks
 * @Date: Created by 15:53 2018/8/13
 * @Package: com.ace.trade.common.exception
 * @Description:
 */
public class OrderException extends RuntimeException {
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderException(Throwable cause) {
        super(cause);
    }

}
