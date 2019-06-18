package com.nxist.springmvc.handlers;

import com.nxist.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @Author: xym760
 * @Date: 2019/6/14 17:45
 * @Description:
 */
@SessionAttributes(value = {"user"}, types = {String.class})
@Controller
@RequestMapping("/springmvc")
public class SpringMvcTest {

    private static final String SUCCESS = "success";

    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    /**
     * 有@ModelAttribute注解标记的方法，会在每个目标方法执行之前被SpringMVC调用！
     *
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        System.out.println("modelAttribute method");
        if (id != null) {
            //模拟从数据库中获取对象
            User user = new User(1, "Tom", "123", "tom@nxist.com", 22);
            System.out.println("从数据库中获取一个对象：" + user);
            map.put("user", user);
        }
    }

    /**
     * 运行流程：
     * 1.执行@ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放入到了Map中。键为：user
     * 2.SpringMVC从Map中取出User对象，并把表单的请求参数赋给该User对象的对应属性。
     * 3.SpringMVC把上述对象传入目标方法的参数。
     * <p>
     * 注意：在@ModelAttribute修饰的方法中，放入到Map时的键需要和目标方法入参类型的第一个字母小写的字符串一致！
     * <p>
     * SpringMVC 确定目标方法 POJO 类型入参的过程：
     * 1） 确定一个 key:
     * ①若目标方法的 POJO 类型的参数木有使用 @ModelAttribute 作为修饰,则 key 为 POJO 类名第一个字母的小写
     * ②若使用了@ModelAttribute 来修饰, 则 key 为 @ModelAttribute 注解的value 属性值.
     * 2） 在 implicitModel 中查找 key 对应的对象, 若存在, 则作为入参传入
     * 若在 @ModelAttribute 标记的方法中在 Map 中保存过, 且 key 和 1）确定的 key 一致, 则会获取到.
     * 3） 若 implicitModel 中不存在 key 对应的对象, 则检查当前的 Handler 是否使用
     *
     * @param user
     * @return
     * @SessionAttributes 注解修饰,
     * 4） 若使用了该注解, 且 @SessionAttributes 注解的 value 属性值中包含了 key, 则会
     * 从 HttpSession 中来获取 key 所对应的 value 值, 若存在则直接传入到目标方法
     * 的入参中. 若不存在则将抛出异常.
     * 5） 若 Handler 没有标识 @SessionAttributes 注解或 @SessionAttributes 注解的
     * value 值中不包含 key, 则会通过反射来创建 POJO 类型的参数, 传入为目标方法
     * 的参数
     * 6） SpringMVC 会把 key 和 POJO 类型的对象保存到 implicitModel 中, 进而会保存
     * 到 request 中.
     * <p>
     * 源代码流程：
     * 1） 调用 @ModelAttribute 注解修饰的方法. 实际上把 @ModelAttribute 方法中 Map中的数据放在了 implicitModel 中.
     * 2） 解析请求处理器的目标参数, 实际上该目标参数来自于 WebDataBinder 对象的target 属性
     * ① 创建 WebDataBinder 对象
     * ② 确定 objectName 属性: 若传入的 attrName 属性值为 "", 则 objectName 为类名第一个字母小写.
     * 注意: attrName. 若目标方法的 POJO 属性使用了 @ModelAttribute 来修饰, 则 attrName 值即为 @ModelAttribute 的 value 属性值
     * ③确定 target 属性:
     *  在 implicitModel 中查找 attrName 对应的属性值.
     *  若存在, ok
     *  若不存在: 则验证当前 Handler 是否使用了@SessionAttributes 进行修饰,
     *  若使用了, 则尝试从 Session 中获取 attrName 所对应的属性值.
     *  若 session 中没有对应的属性值, 则抛出了异常.
     *  若Handler没有使用@SessionAttributes进行修饰,或@SessionAttributes 中没有使用 value 值指定的 key 和 attrName 相匹配,
     * 则通过反射创建了 POJO 对象
     * 3） SpringMVC 把表单的请求参数赋给了 WebDataBinder 的 target 对应的属性.
     * 4） SpringMVC 会把 WebDataBinder 的 attrName 和 target 给到 implicitModel. 进而传到 request 域对象中.
     * 5） 把 WebDataBinder 的 target 作为参数传递给目标方法的入参.
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("修改：" + user);
        return SUCCESS;
    }

    /**
     * @param map
     * @return
     * @SessionAttributes除了可以通过属性名指定需要放到回话中的属性外（实际使用的是value属性值）， 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（实际上使用的是types属性值）
     * 注意：该注解只能放在类的上面，而不能修饰方法
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        User user = new User("Tom", "jk14101", "tom@nxist.com", 15);
        map.put("user", user);
        map.put("college", "nxist");
        return SUCCESS;
    }

    /**
     * 目标方法可以添加Map类型(实际上也可以是Model类型或ModelMap类型)的参数。
     *
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }

    /**
     * 目标方法的返回值可以是ModelAndView类型。
     * 其中可以包含视图和模型信息
     * SpringMVC 会把ModelAndView的model中的数据放入到request域对象中。
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        //添加模型数据到ModelAndView中
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    /**
     * 可以使用servlet的原生API作为目标方法的参数
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI，" + request + "， " + response);
        out.write("hello springmvc");
//        return SUCCESS;
    }

    /**
     * spring mvc会按请求参数名和POJO属性名进行自动匹配，
     * 自动为该对象填充属性值。支持级联属性。
     * 如address.city,address.province等
     *
     * @param user
     * @return
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo:" + user);
        return SUCCESS;
    }

    /**
     * @param JSESSIONID
     * @return
     * @CookieValue注解用于获取Cookie值
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println("testCookieValue:JSESSIONID=" + JSESSIONID);
        return SUCCESS;
    }

    /**
     * 映射请求头信息，用法同@RequestParam注解
     *
     * @param al
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
        System.out.println("Accept-Language:" + al);
        return SUCCESS;
    }

    /**
     * @param un
     * @param age
     * @return
     * @RequestParam来映射请求参数。 value值即请求参数的参数名
     * required 该参数值是否必须，默认为true
     * defaultValue 即参数默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String un, @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam，username:" + un + ",age:" + age);
        return SUCCESS;
    }

    /**
     * Rest风格URL
     * 以CRUD为例
     * 新增：/order POST
     * 修改：/order/1 PUT      update?id=1
     * 获取：/order/1 GET      get?id=1
     * 删除：/order/1 DELETE   delete?id=1
     * 如何发送PUT请求或DELETE请求？
     * 1.需要配置HiddenHttpMethodFilter
     * 2.需要发送POST请求
     * 3.需要在发送POST请求时携带一个name="_method"的隐藏域，值为PUT或DELETE
     * <p>
     * 在Spring mvc的目标方法中如何得到id呢？
     * 使用@PathVariable注解
     *
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
