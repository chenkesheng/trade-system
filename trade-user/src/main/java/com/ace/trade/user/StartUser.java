package com.ace.trade.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: cks
 * @Date: Created by 20:10 2018/8/12
 * @Package: com.ace.trade.user
 * @Description:
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class StartUser {
    public static void main(String[] args) {
        SpringApplication.run(StartUser.class, args);
    }
}
