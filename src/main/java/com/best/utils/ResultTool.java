package com.best.utils;


import com.best.entity.JsonResult;
import com.best.entity.enums.ResultCode;

/**
 * @author:sunxj
 * @date:2020-11-10 22:11:03
 * @description:json返回构造工具
 */
public class ResultTool {
    public static JsonResult success() {
        return new JsonResult(true);
    }
    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(true,data);
    }
    public static JsonResult fail() {
        return new JsonResult(false);
    }
    public static JsonResult fail(ResultCode resultCode) {
        return new JsonResult(false,resultCode);
    }
}
