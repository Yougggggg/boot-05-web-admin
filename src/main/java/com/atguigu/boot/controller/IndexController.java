package com.atguigu.boot.controller;

import com.atguigu.boot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * 用户登录
 * @Author: youyong
 * @Description: TODO
 * @DateTime: 2021/12/6 13:50
 **/
@Slf4j
@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session,Model model){
        if (StringUtils.hasLength(user.getUsername())&&"123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账户或密码错误！");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
//        Object user = session.getAttribute("loginUser");
//        if (user!=null){
//            return "main";
//        }else {
//            model.addAttribute("msg","重新登录！");
//            return "login";
//        }
        log.info("main请求");
        return "main";
    }



}
