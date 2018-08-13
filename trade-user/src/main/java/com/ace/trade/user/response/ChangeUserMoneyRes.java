package com.ace.trade.user.response;

/**
 * @Author: cks
 * @Date: Created by 20:16 2018/8/13
 * @Package: com.ace.trade.user.response
 * @Description:
 */
public class ChangeUserMoneyRes {

    private String resultCode;

    private String ResultInfo;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return ResultInfo;
    }

    public void setResultInfo(String resultInfo) {
        ResultInfo = resultInfo;
    }
}
