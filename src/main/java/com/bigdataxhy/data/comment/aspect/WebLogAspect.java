package com.bigdataxhy.data.comment.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * AOP切面，答应请求日志，和返回内容
 * @AUTHOR xianghy
 * @DATE Created on 2018/7/3 17:37.
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.bigdataxhy.data.controller.*.*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        // 收到请求，记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 记录web请求内容
        logger.info("<<<<<<<<<<<<<<<<URL :" + request.getRequestURI().toString());
        logger.info("<<<<<<<<<<<<<<<<HTTP_METHOD :" + request.getMethod());
        logger.info("<<<<<<<<<<<<<<<<IP :" + request.getRemoteAddr());
        logger.info("<<<<<<<<<<<<<<<<CLASS_METHOD :" + joinPoint.getSignature().getDeclaringTypeName() +  "." + joinPoint.getSignature().getName());
        logger.info("<<<<<<<<<<<<<<<<ARGS :" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 答应返回内容
        logger.info("RESPONSE 》》》》》》》》》》》》》》》" + ret);
    }

}
