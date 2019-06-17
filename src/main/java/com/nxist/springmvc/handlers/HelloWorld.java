package com.nxist.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xym760
 * @Date: 2019/6/14 14:15
 * @Description:
 */
@Controller
public class HelloWorld {
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }
}
