<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/6/1
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试页</title>
</head>
<body>
<ul>
    <c:forEach var="name" items="${users}">
        <li>${name}</li>
    </c:forEach>
</ul>
</body>
</html>
