<%--
  Created by IntelliJ IDEA.
  User: xym760
  Date: 2019/6/20
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fmt:message key="i18n.username"></fmt:message>

<br><br>
<a href="i18n2">I18N2 PAGE</a>

<br><br>
<a href="i18n?locale=zh_CH">中文</a>

<br><br>
<a href="i18n?locale=en_US">英文</a>
</body>
</html>
