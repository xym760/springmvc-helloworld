<%--
  Created by IntelliJ IDEA.
  User: xym760
  Date: 2019/6/13
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <script src="scripts/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $("#testJson").click(function () {
                var url = this.href;
                var args = {};
                $.post(url, args, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var id = data[i].id;
                        var lastName = data[i].lastName;
                        alert(id + ": " + lastName)
                    }

                })
                return false;
            });
        })
    </script>
</head>

<form action="testFileUpload" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file">
    Desc:<input type="text" name="desc">
    <input type="submit" value="Submit">
</form>
<br><br>

<a href="emps">List All Employees</a>
<br><br>

<a href="testJson" id="testJson">Test Json</a>
<br><br>

<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file">
    Desc:<input type="text" name="desc">
    <input type="submit" value="Submit">
</form>
<br><br>

<a href="testResponseEntity">Test ResponseEntity</a>
<br><br>
<%--
关于国际化：
1.在页面上能够根据浏览器语言设置的情况对文本（不是内容）、时间、数值进行本地化处理
2.可以在bean中获取国际化资源文件Locale对应的消息
3.可以通过超链接切换Locale，而不再依赖于浏览器的语言设置情况

如何解决：
1.使用JSTL的fmt标签
2.在bean中注入ResourceBundleMessageSource实例，使用期对应的getMessage
3.配置LocalResolver和LocaleChangeInterceptor
--%>
<a href="i18n">I18N PAGE</a>
<br><br>

<a href="testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>
<br><br>

<a href="testResponseStatusExceptionResolver?i=10">Test ResponseStatusExceptionResolver</a>
<br><br>

<a href="testDefaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>
<br><br>

<a href="testSimpleMappingExceptionResolver?i=2">Test SimpleMappingExceptionResolver</a>
<br><br>

<a href="springmvc/testRedirect">Test Redirect</a>
<br><br>

<a href="springmvc/testView">Test View</a>
<br><br>

<a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
<br><br>

<%--
模拟修改操作
1.原始数据为：1，Tom，123，tom@nxist.com，22
2.密码不能被修改。
3.表单回显，模拟操作直接在表单填写对应的属性值，不查数据库
--%>
<form action="springmvc/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">
    username:<input type="text" name="username" value="Tom">
    <br>
    email:<input type="text" name="email" value="tom@nxist.com">
    <br>
    age:<input type="text" name="age" value="12">
    <br>
    <input type="submit" value="Submit">
</form>
<br><br>

<a href="springmvc/testSessionAttributes">Test SessionAttributes</a>
<br><br>

<a href="springmvc/testMap">Test Map</a>
<br><br>

<a href="springmvc/testModelAndView">Test ModelAndView</a>
<br><br>

<a href="springmvc/testServletAPI">Test ServletAPI</a>
<br><br>

<form action="springmvc/testPojo" method="post">
    username:<input type="text" name="username">
    <br>
    password:<input type="password" name="password">
    <br>
    email:<input type="text" name="email">
    <br>
    age:<input type="text" name="age">
    <br>
    city:<input type="text" name="address.city">
    <br>
    province:<input type="text" name="address.province">
    <br>
    <input type="submit" value="Submit">
</form>
<br><br>

<a href="springmvc/testCookieValue">Test CookieValue</a>
<br><br>

<a href="springmvc/testRequestHeader">Test RequestHeader</a>
<br><br>

<a href="springmvc/testRequestParam?username=nxist&age=11">Test RequestParam</a>
<br><br>

<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="TestRest PUT">
</form>
<br><br>

<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="TestRest DELETE">
</form>
<br><br>

<form action="springmvc/testRest" method="post">
    <input type="submit" value="TestRest POST">
</form>
<br><br>

<br><br>
<a href="springmvc/testRest/1">Test Rest Get</a>
<br><br>

<body>
<a href="springmvc/testPathVariable/1">Test PathVariable</a>
<br><br>

<a href="springmvc/testAntPath/nxistxy/abc">Test AntPath</a>
<br><br>

<a href="springmvc/testParamsAndHeaders?username=nxist&age=11">Test ParamsAndHeaders</a>
<br><br>

<form action="springmvc/testMethod" method="post">
    <input type="submit" value="submit">
</form>
<br><br>

<a href="springmvc/testMethod">Test Method</a>
<br><br>

<a href="springmvc/testRequestMapping">Test RequestMapping</a>
<br><br>

<a href="helloworld">hello world</a>
</body>
</html>
