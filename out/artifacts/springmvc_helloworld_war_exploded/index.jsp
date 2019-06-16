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
