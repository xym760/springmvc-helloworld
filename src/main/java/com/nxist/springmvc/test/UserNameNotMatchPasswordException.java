package com.nxist.springmvc.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: xym760
 * @Date: 2019/6/21 14:44
 * @Description:
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户名和密码不匹配！")
public class UserNameNotMatchPasswordException extends RuntimeException {


    private static final long serialVersionUID = -7198733638506590438L;
}
