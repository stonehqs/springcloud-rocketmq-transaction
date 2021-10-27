package com.hqs.chargeorderservice.untils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Description: json工具类
 *
 *
 * @date 2019/7/12 下午12:58
 */
public class JsonUtils {


    private static final ObjectMapper objectMappper = new ObjectMapper();

    /**
     * json字符串转JsonNode对象的方法
     */
    public static JsonNode str2JsonNode(String str){
        try {
            return  objectMappper.readTree(str);
        } catch (IOException e) {
            return null;
        }
    }
}
