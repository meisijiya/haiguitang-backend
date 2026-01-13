package com.meisijiya.haiguitangbackend.util;


import cn.hutool.core.util.IdUtil;

import java.util.UUID;

public class CodeGeneratorUtil {
    /**
     * 生成指定长度的验证码
     * @param length 长度
     */
    public static String generateCode(int length){
        return UUID.randomUUID().toString().substring(0, length);
    }

    /**
     * 生成唯一用户账号
     */
    public static String generateUserAccount(){
        return "user_" + snowflake();
    }

    /**
     * 雪花算法生成用户注册的id
     */
    public static long snowflake(){
        return IdUtil.getSnowflakeNextId();
    }
}
