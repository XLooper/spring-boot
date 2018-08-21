package com.bigdataxhy.data.exception;


import com.bigdataxhy.data.domain.bizpojo.enums.exception.ErrorEnum;

/**
 * 系统异常类
 */
public class SystemException extends BaseException {

    public SystemException(ErrorEnum error) {
        super(error);
    }

    public SystemException(ErrorEnum error, Object data) {
        super(error, data);
    }
}
