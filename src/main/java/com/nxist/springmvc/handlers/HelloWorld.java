package com.nxist.springmvc.handlers;

import com.nxist.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xym760
 * @Date: 2019/6/14 14:15
 * @Description:
 */
@Controller
public class HelloWorld {
    @Autowired
    private UserService userService;

    public HelloWorld() {
        System.out.println("HelloWorld Constructor...");
    }

    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("hello world");
        System.out.println(userService);
        return "success";
    }
}
