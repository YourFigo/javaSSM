<%--
  Created by IntelliJ IDEA.
  User: Figo
  Date: 2019/11/30
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="user/hello">入门</a>

    <a href="user/testRequestMapping?username=tom">测试RequestMapping注解</a>

    <form action="user/testParams">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额: <input type="text" name="money"><br>
        用户名: <input type="text" name="user.uname"><br>
        年龄: <input type="text" name="user.age"><br>
        用户名: <input type="text" name="list[0].uname"><br>
        年龄: <input type="text" name="list[0].age"><br>
        用户名: <input type="text" name="map['one'].uname"><br>
        年龄: <input type="text" name="map['one'].age"><br>
        <input type="submit" value="提交">
    </form>

    <form action="user/testParamsConvert">
        用户名: <input type="text" name="uname"><br>
        年龄: <input type="text" name="age"><br>
        生日: <input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>

    <a href="user/testServlet">获取servlet的api</a>
</body>
</html>
