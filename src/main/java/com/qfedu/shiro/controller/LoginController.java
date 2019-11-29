package com.qfedu.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String name,String password){

        System.out.println("控制层"+name+password);
        //存储输入的用户密码
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            //登录判断
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "error";
        }
        return "index";
    }
}
