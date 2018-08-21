package com.bigdataxhy.data.exception;


import com.bigdataxhy.data.domain.bizpojo.enums.exception.ErrorEnum;

/**
 * 参数异常类
 */
public class ParamException extends BaseException {

    public ParamException(ErrorEnum error) {
        super(error);
    }

    public ParamException(ErrorEnum error, Object data) {
        super(error, data);
    }
}
