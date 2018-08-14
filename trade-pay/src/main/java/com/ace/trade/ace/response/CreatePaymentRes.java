package com.ace.trade.ace.response;

/**
 * @Author: cks
 * @Date: Created by 16:51 2018/8/14
 * @Package: com.ace.trade.ace.response
 * @Description:
 */
public class CreatePaymentRes {
    private String resultCode;

    private String resultInfo;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
}
