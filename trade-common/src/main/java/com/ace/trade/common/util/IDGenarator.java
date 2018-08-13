package com.ace.trade.common.util;

import java.util.UUID;

/**
 * @Author: cks
 * @Date: Created by 16:20 2018/8/13
 * @Package: com.ace.trade.common.util
 * @Description:
 */
public class IDGenarator {

    public static String generatorUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
