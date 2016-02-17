package com.lu.domain;

/**
 * Created by wuzhong on 16/1/22.
 */
public class Result<T> {

    public static final int ERROR_CODE_NO_LOGIN = -1;
    public static final int ERROR_CODE_NO_PERMISSION = -2;
    public static final int ERROR_CODE_ERROR_PARAM = -3;
    public static final int ERROR_CODE_LOGIN_FAILED = -4;
    public static final int ERROR_CODE_EXCEPTION = -99;

    public static final Result NO_LOGIN = new Result(false, ERROR_CODE_NO_LOGIN,"no login");
    public static final Result NO_PERMISSION = new Result(false, ERROR_CODE_NO_PERMISSION,"no permission");
    public static final Result ERROR_PARAM = new Result(false, ERROR_CODE_ERROR_PARAM,"param error");
    public static final Result EXCEPTION = new Result(false, ERROR_CODE_EXCEPTION,"exception");


    private boolean success;
    private int code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
