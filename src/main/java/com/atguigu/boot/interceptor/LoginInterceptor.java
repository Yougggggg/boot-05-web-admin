package com.atguigu.boot.interceptor;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: youyong
 * @Description: TODO
 * @DateTime: 2021/12/10 14:53
 **/
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 请求处理前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        log.info("请求拦截："+requestURL);
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            //放行
            return true;
        }

        //拦截之后就要提示用户登录
        request.setAttribute("msg","请重新登录");
        request.getRequestDispatcher("/").forward(request,response);
        //拦截
        return false;
    }

    /**
     * 请求处理后的拦截
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle拦截："+modelAndView);
    }

    /**
     * 页面渲染后的拦截
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion拦截："+ex);
    }
}
