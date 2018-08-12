package com.ace.trade.common.constants;

/**
 * @Author: cks
 * @Date: Created by 20:13 2018/8/12
 * @Package: com.ace.trade.common.constants
 * @Description:
 */
public enum TradeEnums {
    SUCCESS("1","成功"),
    FAIL("-1","失败")
    ;
    private String code;
    private String desc;

    TradeEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
