package com.nxist.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xym760
 * @Date: 2019/6/14 17:45
 * @Description:
 */
@Controller
@RequestMapping("/springmvc")
public class SpringMvcTest {
    private static final String SUCCESS = "success";

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
