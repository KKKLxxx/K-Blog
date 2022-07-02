package com.kkkl.kblogserver.util;

import java.util.HashMap;

public class ResultFormat {
    public static HashMap<String, Object> formatResult(int code, Object data) {
        HashMap<String, Object> result = new HashMap<>(2);
        result.put("code", code);
        result.put("data", data);
        return result;
    }
}
