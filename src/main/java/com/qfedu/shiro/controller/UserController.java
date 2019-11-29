package com.qfedu.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    //注解设置需要的权限
    @RequiresPermissions("role:list")
    @RequestMapping("/user/list")
    public String userList(){
        return "list";
    }

    @RequestMapping("/noPerm")
    public String noperms(){

        return "noperms";
    }
}
