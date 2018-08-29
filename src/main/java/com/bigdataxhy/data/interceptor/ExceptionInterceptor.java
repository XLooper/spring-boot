package com.bigdataxhy.data.interceptor;

import com.alibaba.fastjson.JSON;
import com.bigdataxhy.data.aop.ControllerLogAspect;
import com.bigdataxhy.data.comment.api.ApiResponse;
import com.bigdataxhy.data.domain.bizpojo.enums.exception.ErrorEnum;
import com.bigdataxhy.data.exception.BaseException;
import com.bigdataxhy.data.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * @AUTHOR xianghy
 * @DATE Created on 2018/8/21 16:20.
 */
@Component
public class ExceptionInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ControllerLogAspect aspect;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception exception) throws Exception {

        if (exception == null) {
            return;
        }
        ApiResponse apiResponse = ApiResponse.error();
        logger.error(exception.getMessage());
        if (exception instanceof BaseException) {
            BaseException base = (BaseException) exception;
            apiResponse.setCode(base.getErrorCode()).setMsg(base.getErrorMessage());
            apiResponse.setData(base.getData() == null ? "" : base.getData());
        } else {
            ErrorEnum errorEnum = ErrorEnum.SYSTEM_ERROR;
            apiResponse.setCode(errorEnum.code()).setMsg(errorEnum.value());
        }
        aspect.logProxy(request, apiResponse.getMsg(), exception);

        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSON(apiResponse));
        out.flush();
        out.close();
    }
}
