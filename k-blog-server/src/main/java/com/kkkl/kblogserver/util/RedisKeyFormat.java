package com.kkkl.kblogserver.util;

public class RedisKeyFormat {

    public static String formatRegisterKey(String email) {
        return "REGISTER_" + email;
    }
}
