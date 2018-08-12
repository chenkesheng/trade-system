package com.ace.trade.common.exception;

/**
 * @Author: cks
 * @Date: Created by 10:08 2018/8/12
 * @Package: com.ace.trade.common.exception
 * @Description: 自定义MQ异常
 */
public class AceMQException extends Exception {

    private static final long serialVersionUID = -6609666624350948769L;

    public AceMQException() {
        super();
    }

    public AceMQException(String message) {
        super(message);
    }

    public AceMQException(String message, Throwable cause) {
        super(message, cause);
    }

    public AceMQException(Throwable cause) {
        super(cause);
    }
}
