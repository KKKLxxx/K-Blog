package com.kkkl.kblogserver.util;

import java.util.Random;

public class RandomValueUtil {

    private static final Random random = new Random();
    private static final String SYMBOLS = "0123456789";

    /**
     * 生成4位随机int
     */
    public static String get4Int() {
        char[] res = new char[4];
        for (int i = 0; i < res.length; i++) {
            res[i] = SYMBOLS.charAt(random.nextInt(res.length));
        }
        return new String(res);
    }
}
