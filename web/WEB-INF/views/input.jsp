<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xym760
  Date: 2019/6/19
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
1.为什么使用form标签呢？
可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
2.可以通过 modelAttribute 指定绑定的模型属性，
若没有指定该属性，则默认从 request 域中查找 command 的表单的 bean 如果该属性也不存在，那么，则会发生错误。
--%>
<%--此处action写绝对路径：${pageContext.request.contextPath}/，不然报错爽死你--%>
<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
    <c:if test="${employee.id==null}">
        <%--path属性对应html表单标签的name属性值--%>
        LastName:<form:input path="lastName"></form:input>
    </c:if>
    <c:if test="${employee.id!=null}">
        <form:hidden path="id"></form:hidden>
        <input type="hidden" name="_method" value="put">
        <%--对于_method不能使用form:hidden标签，因为modelAttribute对应的bean中没有_method这个属性--%>
        <%--<form:hidden path="_method" value="put"></form:hidden>--%>
    </c:if>
    <br>
    Email:<form:input path="email"></form:input>
    <br>
    <%
        Map<String, String> genders = new HashMap<>();
        genders.put("1", "male");
        genders.put("0", "female");
        request.setAttribute("genders", genders);
    %>
    Gender:
    <br>
    <form:radiobuttons path="gender" items="${genders}" delimiter="<br>"></form:radiobuttons>
    <br>
    Department:<form:select path="department.id" items="${departments}" itemLabel="departmentName"
                            itemValue="id"></form:select>
    <br>
    <%--
    1.数据类型转换
    2.数据类型格式化
    3.数据校验
    --%>
    <%--Brith:<form:input path="birth"></form:input>--%>
    <%--<br>--%>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
