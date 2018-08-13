package com.ace.trade.common.constants;

/**
 * @Author: cks
 * @Date: Created by 20:13 2018/8/12
 * @Package: com.ace.trade.common.constants
 * @Description:
 */
public class TradeEnums {
    public enum ResultEnum {
        SUCCESS("1", "成功"),
        FAIL("-1", "失败");
        private String code;
        private String desc;

        ResultEnum(String code, String desc) {
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

    public enum OrderStatusEnum {
        NO_CONFIRM("0", "未确认"),
        CONFIRM("1", "已确认"),
        CANCEL("2", "已取消"),
        INVALID("3", "无效"),
        REFUNDED("4", "退货");
        private String statusCode;
        private String desc;

        OrderStatusEnum(String statusCode, String desc) {
            this.statusCode = statusCode;
            this.desc = desc;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public enum PayStatusEnum {

        NO_PAY("0", "未付款"),
        PAYING("1", "支付中"),
        PAID("2", "已付款");
        private String statusCode;
        private String desc;

        PayStatusEnum(String statusCode, String desc) {
            this.statusCode = statusCode;
            this.desc = desc;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public enum ShippingStatusEnum {

        NO_SHIP("0", "未发货"),
        SHIPPED("1", "已发货"),
        RECEVIED("2", "已收货");
        private String statusCode;
        private String desc;

        ShippingStatusEnum(String statusCode, String desc) {
            this.statusCode = statusCode;
            this.desc = desc;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public enum UserMoneyLogTypeEnum {

        PAID("1", "订单付款"),
        REFUND("2", "订单退款");
        private String code;
        private String desc;

        UserMoneyLogTypeEnum(String code, String desc) {
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

    public enum YesOrNoEnum {

        NO("0", "否"),
        YES("1", "是");
        private String code;
        private String desc;

        YesOrNoEnum(String code, String desc) {
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
}
