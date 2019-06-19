package com.nxist.springmvc.test;

import com.nxist.springmvc.crud.dao.EmployeeDao;
import com.nxist.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee") Employee employee) {
        System.out.println("save" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
