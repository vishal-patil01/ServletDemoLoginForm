<%--
  Created by IntelliJ IDEA.
  User: Vishal Rajput
  Date: 08/04/2020
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success <Page></Page></title>
</head>
<body>
<h1>Hi <%= request.getAttribute("userName")%>,Login Successful !</h1>
<a href="login.html">Login Page</a>
</body>
</html>
