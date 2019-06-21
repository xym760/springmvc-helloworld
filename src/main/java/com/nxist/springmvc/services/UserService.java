package com.nxist.springmvc.services;

import com.nxist.springmvc.handlers.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserService() {
        System.out.println("UserService Constructor...");
    }
}
