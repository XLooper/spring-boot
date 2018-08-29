package com.bigdataxhy.data.adapter;

import com.bigdataxhy.data.interceptor.ExceptionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xianghy
 * @date Created on 2018/8/29
 */
@SpringBootConfiguration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    ExceptionInterceptor exceptionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(exceptionInterceptor).addPathPatterns("/**");

    }
}
