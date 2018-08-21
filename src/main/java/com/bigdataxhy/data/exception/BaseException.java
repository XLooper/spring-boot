package com.bigdataxhy.data.exception;


import com.bigdataxhy.data.domain.bizpojo.enums.exception.ErrorEnum;

/**
 * 系统异常类
 */
public class BaseException extends RuntimeException {

    /**
     * 已经约定好的 错误类型
     */
    private ErrorEnum error;

    /**
     * 自定义的 报错具体数据
     */
    private Object data;

    public ErrorEnum getErrorEnum() {
        return error;
    }

    public Integer getErrorCode() {
        return error == null ? null : error.code();
    }

    public String getErrorMessage() {
        return error == null ? "" : error.value();
    }

    public Object getData() {
        return data;
    }

    public BaseException(ErrorEnum error) {
        super(error == null ? "" : error.value());
        this.error = error;
    }

    public BaseException(ErrorEnum error, Object data) {
        this(error);
        this.data = data;
    }
}
