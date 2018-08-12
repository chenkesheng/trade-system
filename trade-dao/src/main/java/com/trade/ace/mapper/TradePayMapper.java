package com.trade.ace.mapper;

import com.trade.ace.entity.TradePay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradePayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String payId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated
     */
    int insert(TradePay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated
     */
    TradePay selectByPrimaryKey(String payId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated
     */
    List<TradePay> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TradePay record);
}