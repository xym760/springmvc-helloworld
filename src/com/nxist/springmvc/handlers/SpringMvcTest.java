package com.nxist.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xym760
 * @Date: 2019/6/14 17:45
 * @Description:
 */
@Controller
@RequestMapping("/springmvc")
public class SpringMvcTest {
    private static final String SUCCESS = "success";

    /**
     *Rest风格URL
     * 以CRUD为例
     * 新增：/order POST
     * 修改：/order/1 PUT      update?id=1
     * 获取：/order/1 GET      get?id=1
     * 删除：/order/1 DELETE   delete?id=1
     * 如何发送PUT请求或DELETE请求？
     * 1.需要配置HiddenHttpMethodFilter
     * 2.需要发送POST请求
     * 3.需要在发送POST请求时携带一个name="_method"的隐藏域，值为PUT或DELETE
     *
     * 在Spring mvc的目标方法中如何得到id呢？
     * 使用@PathVariable注解
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id) {
        System.out.println("testRest PUT: " + id);
        return SUCCESS;
    }

    @ResponseBody
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id) {
        System.out.println("testRest DELETE: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest() {
        System.out.println("testRest POST");
        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable("id") Integer id) {
        System.out.println("testRest GET: " + id);
        return SUCCESS;
    }

    /**
     * @param id
     * @return
     * @PathVariable可以来映射url中的占位符到目标方法的参数中。
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable's id:" + id);
        return SUCCESS;
    }

    /**
     * 测试Spring Ant风格资源请求地址
     * 映射中的*号表示可以支持任意字符
     *
     * @return
     */
    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * 使用params和headers来更加精确的映射请求。params和headers支持简单的表达式
     * 注意：配置params和headers参数时，等号前后不能有空格
     *
     * @return
     */
    @RequestMapping(value = "testParamsAndHeaders", params = {"username", "age!=10"}, headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 使用method属性来指定请求方式
     *
     * @return
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
