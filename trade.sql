/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.28 : Database - trade
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `trade_coupon` */

DROP TABLE IF EXISTS `trade_coupon`;

CREATE TABLE `trade_coupon` (
  `coupon_id` varchar(32) NOT NULL COMMENT '优惠券Id',
  `coupon_price` decimal(10,2) DEFAULT NULL COMMENT '优惠卷金额',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `order_id` varchar(32) DEFAULT NULL COMMENT '订单id',
  `is_used` char(1) DEFAULT NULL COMMENT '是否使用 0.未使用 1.已使用',
  `used_time` datetime DEFAULT NULL COMMENT '使用时间',
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trade_coupon` */

/*Table structure for table `trade_goods` */

DROP TABLE IF EXISTS `trade_goods`;

CREATE TABLE `trade_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品Id',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goods_number` int(11) DEFAULT NULL COMMENT '商品库存',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `add_time` datetime DEFAULT NULL COMMENT '商品添加时间',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trade_goods` */

/*Table structure for table `trade_goods_number_log` */

DROP TABLE IF EXISTS `trade_goods_number_log`;

CREATE TABLE `trade_goods_number_log` (
  `goods_id` int(11) NOT NULL COMMENT '商品Id',
  `order_id` varchar(32) NOT NULL COMMENT '订单Id',
  `goods_number` int(11) NOT NULL COMMENT '库存数量',
  `log_time` datetime NOT NULL COMMENT '记录时间',
  KEY `goods_id` (`goods_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trade_goods_number_log` */

/*Table structure for table `trade_mq_consumer_log` */

DROP TABLE IF EXISTS `trade_mq_consumer_log`;

CREATE TABLE `trade_mq_consumer_log` (
  `group_name` varchar(255) NOT NULL COMMENT '消费组名',
  `msg_tags` varchar(255) NOT NULL COMMENT '消息tag',
  `msg_keys` varchar(255) NOT NULL COMMENT '业务Id',
  `msg_id` varchar(255) DEFAULT NULL COMMENT '消息id',
  `msg_body` varchar(1024) DEFAULT NULL COMMENT '消息内容',
  `consumer_status` varchar(1) DEFAULT NULL COMMENT '消费状态 0.正在处理 1.处理成功 2.处理失败',
  `consumer_times` int(11) DEFAULT NULL COMMENT '消费次数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注错误原因',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁版本号控制',
  PRIMARY KEY (`group_name`,`msg_tags`,`msg_keys`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trade_mq_consumer_log` */

/*Table structure for table `trade_mq_producer_temp` */

DROP TABLE IF EXISTS `trade_mq_producer_temp`;

CREATE TABLE `trade_mq_producer_temp` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `group_name` varchar(255) NOT NULL COMMENT '生产者组名',
  `msg_topic` varchar(255) DEFAULT NULL COMMENT '消息主题',
  `msg_tag` varchar(255) NOT NULL COMMENT '消息tag',
  `msg_keys` varchar(255) NOT NULL COMMENT '消息keys',
  `msg_body` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trade_mq_producer_temp` */

/*Table structure for table `trade_order` */

DROP TABLE IF EXISTS `trade_order`;

CREATE TABLE `trade_order` (
  `order_id` varchar(32) NOT NULL COMMENT '订单Id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `order_status` char(1) NOT NULL COMMENT '订单状态 0.未确认 1.已确认 2.已取消 3.无效 4.退货',
  `pay_status` char(1) DEFAULT NULL COMMENT '支付状态 0.未付款 1.支付中 2.已付款',
  `shipping_status` char(1) DEFAULT NULL COMMENT '发货状态 0.未发货 1.已发货 2.已收货',
  `addres` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `consignee` varchar(255) DEFAULT NULL COMMENT '收货人',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `goods_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_amount` decimal(10,2) DEFAULT NULL COMMENT '商品总价',
  `shipping_fee` decimal(10,2) DEFAULT NULL COMMENT '运费',
  `order_amoumt` decimal(10,2) DEFAULT NULL COMMENT '订单价格',
  `coupon_id` varchar(32) DEFAULT NULL COMMENT '优惠卷id',
  `coupon_paid` decimal(10,2) DEFAULT NULL COMMENT '优惠卷价格',
  `money_paid` decimal(10,2) DEFAULT NULL COMMENT '已付金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  `confirm_tmie` datetime DEFAULT NULL COMMENT '订单确认时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trade_order` */

/*Table structure for table `trade_pay` */

DROP TABLE IF EXISTS `trade_pay`;

CREATE TABLE `trade_pay` (
  `pay_id` varchar(32) NOT NULL COMMENT '支付编号',
  `order_id` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `is_paid` char(1) DEFAULT NULL COMMENT '支付状态 0.未支付 1.已支付',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trade_pay` */

/*Table structure for table `trade_user` */

DROP TABLE IF EXISTS `trade_user`;

CREATE TABLE `trade_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `user_password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `user_mobile` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  `user_scope` int(11) DEFAULT NULL COMMENT '用户积分',
  `user_reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `user_money` decimal(10,2) DEFAULT NULL COMMENT '用户余额',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `trade_user` */

insert  into `trade_user`(`user_id`,`user_name`,`user_password`,`user_mobile`,`user_scope`,`user_reg_time`,`user_money`) values (1,'张三','123456',NULL,NULL,NULL,'1000.00');

/*Table structure for table `trade_user_money_log` */

DROP TABLE IF EXISTS `trade_user_money_log`;

CREATE TABLE `trade_user_money_log` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `order_id` varchar(32) NOT NULL COMMENT '订单id',
  `money_log_type` int(11) NOT NULL COMMENT '日志类型 1.订单付款 2.订单退款',
  `user_money` decimal(10,2) NOT NULL COMMENT '金额',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`),
  KEY `money_log_type` (`money_log_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trade_user_money_log` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
