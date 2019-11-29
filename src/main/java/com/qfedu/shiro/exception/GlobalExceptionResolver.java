package com.qfedu.shiro.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionResolver {
    //AuthorizationException：授权异常
    @ExceptionHandler(AuthorizationException.class)
    //@ResponseBody //：需要返回ajax数据
    public String nopermException(AuthorizationException ex){
        //跳转到指定的资源
        return "noperms";
    }


}
