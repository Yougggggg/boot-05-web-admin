package com.atguigu.boot.exception;

import lombok.SneakyThrows;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常解析器
 * @Author: youyong
 * @Description: TODO
 * @DateTime: 2021/12/13 22:55
 **/
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @SneakyThrows
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        //也是两种方式：1、返回一个视图对象；2、返回一个ModeAndView，或者发送sendError()请求并返回一个空ModelAndView
        response.sendError(115,"来吧，异常！！！");
        return new ModelAndView();
    }
}
