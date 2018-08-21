package com.bigdataxhy.data.exception;


import com.bigdataxhy.data.domain.bizpojo.enums.exception.ErrorEnum;

/**
 * 业务异常类
 */
public class BusinessException extends BaseException {

    public BusinessException(ErrorEnum error) {
        super(error);
    }

    public BusinessException(ErrorEnum error, Object data) {
        super(error, data);
    }
}
