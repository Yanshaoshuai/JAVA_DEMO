package com.javademo.common.api;

import org.springframework.http.HttpStatus;

@Deprecated
public class ResultOld<T> {
    private final int code;

    private final String status;
    private final String message;
    private final T data;

    public ResultOld(int code, String status, String message, T data) {
        this.code = code;
        this.status=status;
        this.message = message;
        this.data = data;
    }


    public static <T> Result<T> error() {
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null, null);
    }
    public static <T> Result<T> error(HttpStatus status) {
        return new Result<>(status.value(), status.getReasonPhrase(), null, null);
    }
    public static <T> Result<T> error(String message) {
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), message, null);
    }

    public static <T> Result<T> error(HttpStatus status, String message) {
        return new Result<>(status.value(), status.getReasonPhrase(), message, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null, data);
    }

    public static <T> Result<T> ok(T data, String message) {
        return new Result<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), message, data);
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
