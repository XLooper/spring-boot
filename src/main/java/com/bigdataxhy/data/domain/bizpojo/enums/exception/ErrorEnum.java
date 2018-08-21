package com.bigdataxhy.data.domain.bizpojo.enums.exception;

/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/8/21 16:41.
 */
public enum ErrorEnum {

    SYSTEM_ERROR(99999, "系统异常"),
    ;
    private  int code;
    private String value;

    ErrorEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int code() {
        return code;
    }


    public String value() {
        return value;
    }

}
