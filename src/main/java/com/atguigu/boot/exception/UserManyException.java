package com.atguigu.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: youyong
 * @Description: TODO
 * @DateTime: 2021/12/13 22:28
 **/
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户过多")
public class UserManyException extends RuntimeException {

    public UserManyException() {
    }

    public UserManyException(String message) {
        super(message);
    }
}
