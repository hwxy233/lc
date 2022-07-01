package com.hwxy.code.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 干嘛的
 * 
 * @author hwxy
 *
 * @date 2022/04/28
 **/
public class JsonUtil {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T convertToT(String json, Class<T> tClass) {
        try {
            return OBJECT_MAPPER.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T convertToT(String json, TypeReference<T> tTypeReference) {
        try {
            return OBJECT_MAPPER.readValue(json, tTypeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T convertToT(String json) {
        try {
            return OBJECT_MAPPER.readValue(json, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
