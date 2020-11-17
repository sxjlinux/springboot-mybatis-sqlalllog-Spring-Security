package com.best.entity;

import com.best.entity.enums.ResultCode;

import java.io.Serializable;

/**
 * @author:sunxj
 * @date:2020-11-10 22:06:50
 * @description:统一返回的实体类
 */
public class JsonResult<T> implements Serializable {
    private Boolean success;
    private Integer errorCode;
    private String errorMsg;
    private T data;

    public JsonResult() {
    }

    public JsonResult(Boolean success) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode():ResultCode.COMMON_FAIL.getCode();
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage():ResultCode.COMMON_FAIL.getMessage();
    }
    public JsonResult(Boolean success, ResultCode resultCode) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode():(resultCode == null ? ResultCode.COMMON_FAIL.getCode():resultCode.getCode());
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage():(resultCode == null ? ResultCode.COMMON_FAIL.getMessage():resultCode.getMessage());
    }
    public JsonResult(Boolean success, T data) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode():ResultCode.COMMON_FAIL.getCode();
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
        this.data = data;
    }
    public JsonResult(Boolean success, ResultCode resultCode, T data) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode():(resultCode == null ? ResultCode.COMMON_FAIL.getCode():resultCode.getCode());
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage():(resultCode == null ? ResultCode.COMMON_FAIL.getMessage():resultCode.getMessage());
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
