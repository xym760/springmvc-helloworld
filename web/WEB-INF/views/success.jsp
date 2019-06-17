<%--
  Created by IntelliJ IDEA.
  User: xym760
  Date: 2019/6/14
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>success page</h1>
time:${requestScope.time}
<br><br>
names:${requestScope.names}
<br><br>
request user:${requestScope.user}
<br><br>
session user:${sessionScope.user}

<br><br>
request college:${requestScope.college}
<br><br>
session college:${sessionScope.college}
</body>
</html>
