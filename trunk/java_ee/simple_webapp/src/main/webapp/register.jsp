<%--
  Created by IntelliJ IDEA.
  User: oleksiy.konkin
  Date: 10/15/13
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register your account</title>
</head>
<body>
<FORM ACTION="/simple_webapp/registerUserAccount" METHOD="POST">
    Login:
    <INPUT TYPE="TEXT" NAME="login"><BR>
    Password:
    <INPUT TYPE="TEXT" NAME="password"><BR>
    <INPUT TYPE="SUBMIT" VALUE="Register your account">
</FORM>
<p>
<a href="index.jsp">return to the main page</a>
<p>
</body>
</html>