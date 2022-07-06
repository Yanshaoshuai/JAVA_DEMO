package com.javademo.common.api;

@Deprecated
public enum ResultEnum {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR");
    private final int code;
    private final String status;

    ResultEnum(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

}
