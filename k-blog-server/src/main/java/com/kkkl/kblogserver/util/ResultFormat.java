package com.kkkl.kblogserver.util;

import java.util.HashMap;

public class ResultFormat {

    public static int SUCCESS_CODE = 0;

    /**
     正常情况下，简化响应构造
     */
    public static HashMap<String, Object> formatResult(Object data) {
        return formatResult(SUCCESS_CODE, data);
    }

    public static HashMap<String, Object> formatResult(int code, Object data) {
        HashMap<String, Object> result = new HashMap<>(2);
        result.put("code", code);
        result.put("data", data);
        return result;
    }
}
