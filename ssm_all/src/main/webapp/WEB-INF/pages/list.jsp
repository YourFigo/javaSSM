<%--
  Created by IntelliJ IDEA.
  User: Figo
  Date: 2019/12/6
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<body>
    <h3>查询所有的帐户</h3>

    <c:forEach items="${list}" var="account">
        ${account.name}<br>
    </c:forEach>
</body>
</html>
