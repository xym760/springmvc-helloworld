package com.nxist.springmvc.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: xym760
 * @Date: 2019/6/21 11:57
 * @Description:
 */
@ControllerAdvice
public class SpringMVCTestExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception e) {
        System.out.println("------>出异常了： " + e);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }
}
