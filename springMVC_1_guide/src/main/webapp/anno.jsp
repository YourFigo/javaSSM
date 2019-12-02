<%--
  Created by IntelliJ IDEA.
  User: Figo
  Date: 2019/12/2
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>anno</title>
</head>
<body>
    <a href="anno/testRequestParam?name=haha">RequestParam</a>

    <form action="anno/testRequestBody" method="post">
        用户名: <input type="text" name="uname"><br>
        年龄: <input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <a href="anno/testPathVariable/10">testPathVariable</a>

    <!-- 保存 -->
    <form action="springmvc/testRestPOST" method="post">
        用户名称： <input type="text" name="username"><br/>
        <!-- <input type="hidden" name="_method" value="POST"> -->
        <input type="submit" value="保存">
    </form>
    <hr/>
    <!-- 更新 -->
    <form action="springmvc/testRestPUT/1" method="post">
        用户名称： <input type="text" name="username"><br/>
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="更新">
    </form>
    <hr/>
    <!-- 删除 -->
    <form action="springmvc/testRestDELETE/1" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="删除">
    </form>
    <hr/>
    <!-- 查询一个 -->
    <form action="springmvc/testRestGET/1" method="post">
        <input type="hidden" name="_method" value="GET">
        <input type="submit" value="查询">
    </form>

    <hr>
    <a href="anno/testRequestHeader">RequestHeader</a>

    <br>
    <a href="anno/testCookieValue">CookieValue</a>

    <br>
    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <br>
    <a href="anno/testSessionAttributes">testSessionAttributes</a>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <a href="anno/delSessionAttributes">delSessionAttributes</a>

</body>
</html>
