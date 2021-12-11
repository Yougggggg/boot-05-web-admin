package com.atguigu.boot.config;

import com.atguigu.boot.interceptor.LoginInterceptor;
import com.atguigu.boot.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: youyong
 * @Description: TODO
 * @DateTime: 2021/12/10 14:51
 **/
@Configuration
public class AdminConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/**")//拦截所有请求，包括静态资源
                .excludePathPatterns("/","/login","/js/**","/css/**","/images/**","/fonts/**");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有请求，包括静态资源
                .excludePathPatterns("/","/login","/js/**","/css/**","/images/**","/fonts/**");

    }
}
