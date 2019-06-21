package com.nxist.springmvc.test;

import com.nxist.springmvc.crud.dao.EmployeeDao;
import com.nxist.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
        String [] vals=new String[10];
        System.out.println(vals[i]);
        return "success";
    }

    @RequestMapping(value = "/testDefaultHandlerExceptionResolver", method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver() {
        System.out.println("testDefaultHandlerExceptionResolver...");
        return "success";
    }

    @ResponseStatus(reason = "测试", value = HttpStatus.NOT_FOUND)
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i) {
        if (i == 13) {
            throw new UserNameNotMatchPasswordException();
        }
        System.out.println("testResponseStatusExceptionResolver...");
        return "success";
    }

//    @ExceptionHandler({RuntimeException.class})
//    public ModelAndView handleArithmeticException2(Exception e) {
//        System.out.println("[出异常了]： " + e);
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("exception", e);
//        return modelAndView;
//    }

    /**
     * 在当前Handler中定义的ExceptionHandler只能处理当前的Handler的异常，不是全局的
     * 1.在@ExceptionHandler方法的入参中可以加入Exception类型的参数，该参数即对于发生的异常对象
     * 2.@ExceptionHandler方法的入参中不能传入Map.若希望把异常信息传到页面上，需要使用ModelAndView作为返回值
     * 3.@ExceptionHandler方法标记的异常有优先级的问题。
     * 4.@ControllerAdvice：如果在当前Handler中找不到@ExceptionHandler方法来处理当前方法出现的异常，
     * 则将去@ControllerAdvice标记的类中查找@ExceptionHandler标记的方法来处理异常。
     *
     * @param e
     * @return
     */
//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception e) {
//        System.out.println("出异常了： " + e);
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("exception", e);
//        return modelAndView;
//    }
    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i) {
        System.out.println("result: " + (10 / i));
        return "success";
    }

    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("desc: " + desc);
        System.out.println("OriginalFilename: " + file.getOriginalFilename());
        System.out.println("InputStream: " + file.getInputStream());
        return "success";
    }

    @RequestMapping("/i18n")
    public String testI18n(Locale locale) {
        String val = messageSource.getMessage("i18n.username", null, locale);
        System.out.println(val);
        return "i18n";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
        body = new byte[in.available()];
        in.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, statusCode);
        return response;
    }

    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "hello world! " + new Date();
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson() {
        return employeeDao.getAll();
    }

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee") Employee employee) {
        System.out.println("save" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
