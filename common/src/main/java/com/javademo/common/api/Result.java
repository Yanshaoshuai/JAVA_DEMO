package com.javademo.common.api;

public class Result<T> {
    private int code;

    private String status;
    private String message;
    private T data;

    public Result(int code, String status, String message, T data) {
        this.code = code;
        this.status=status;
        this.message = message;
        this.data = data;
    }


    public static <T> Result<T> error() {
        return new Result<>(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getStatus(), null, null);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getStatus(), message, null);
    }

    public static <T> Result<T> error(int code,String message) {
        return new Result<>(code, ResultEnum.ERROR.getStatus(), message, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getStatus(), null, data);
    }

    public static <T> Result<T> ok(T data, String message) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getStatus(), message, data);
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
