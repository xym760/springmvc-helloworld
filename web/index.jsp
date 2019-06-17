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
</head>
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
