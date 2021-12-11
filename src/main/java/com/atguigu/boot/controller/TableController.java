package com.atguigu.boot.controller;

import com.atguigu.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 表格显示
 * @Author: youyong
 * @Description: TODO
 * @DateTime: 2021/12/6 14:34
 **/
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){

        return "/table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("zzz", "123"), new User("bbb", "123"),
                new User("ccc", "123"), new User("ddd", "123"));
        model.addAttribute("users",users);
        return "/table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "/table/editable_table";
    }

}
