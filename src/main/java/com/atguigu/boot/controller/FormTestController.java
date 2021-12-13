package com.atguigu.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 * @Author: youyong
 * @Description: TODO
 * @DateTime: 2021/12/10 20:22
 **/
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(@RequestParam("a")int a){
        int i = 1 / 0;
        return "form/form_layouts.html";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email")String email,
                         @RequestParam("username")String username,
                         @RequestPart("headerImage")MultipartFile headerImage,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {
        log.info("上传信息：email={},username={},headerImage={},photos={},",
                email,username,headerImage.getSize(),photos.length);
        if (!headerImage.isEmpty()){
            String originalFilename = headerImage.getOriginalFilename();
            headerImage.transferTo(new File("G:\\" + originalFilename));
        }
        if (photos.length!=0){
            for (MultipartFile photo : photos) {
                String filename = photo.getOriginalFilename();
                photo.transferTo(new File("G:\\" +filename));
            }
        }
        return "main";
    }
}
