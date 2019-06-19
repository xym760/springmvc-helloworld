<%--
  Created by IntelliJ IDEA.
  User: YuanmaoXu
  Date: 2019/6/18
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--
    SpringMVC处理静态资源：
    1.为什么会有这样的问题：
    优雅的REST风格的资源URL不希望带.html或.do等后缀，若将DispatcherServlet请求映射配置为/,
    则SpringMVC将捕获WEB容器的所有请求,包括静态资源的请求,SpringMVC会将他们当成一个普通请求处理,因找不到对应处理器将导致错误。
    2.解决：
    在springmvc的配置文件中配置<mvc:default-servlet-handler/>
    --%>
    <script src="scripts/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $(".delete").click(function () {
                var href=$(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            });
        })
    </script>
</head>
<body>
<form action="" method="post">
    <input type="hidden" name="_method" value="delete">
</form>

<c:if test="${empty requestScope.employees}">
    没有任何员工信息。
</c:if>
<c:if test="${!empty requestScope.employees}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach items="${requestScope.employees}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender == 0 ? 'Female' : 'Male'}</td>
                <td>${emp.department.departmentName}</td>
                <td><a href="emp/${emp.id}">Edit</a></td>
                <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br><br>
<a href="emp">Add new Employee</a>

</body>
</html>
