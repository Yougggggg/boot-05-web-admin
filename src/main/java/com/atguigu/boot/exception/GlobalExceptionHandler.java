package com.atguigu.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理整个web controller异常
 * @Author: youyong
 * @Description: TODO
 * @DateTime: 2021/12/12 11:28
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})//处理异常
    public String handlerArithException(HttpServletResponse response,Exception ex) throws IOException {
        //异常处理后还是要返回一个ModelAndView的，所以可以直接返回一个视图地址或者返回一个ModelAndView
//        response.sendError(HttpServletResponse.SC_FORBIDDEN,"就要出异常");
//        return new ModelAndView();//返回ModelAndView
        log.info("异常是：{}",ex.toString());
        return "login";//直接放回一个视图地址
    }

}
