<%--
  Created by IntelliJ IDEA.
  User: oleksiy.konkin
  Date: 10/31/13
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Register user account</title>
</head>
<body>

<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");
%>

<p>the login is : <%=login%></p>
<p>the password is : <%=password%></p>
<p>the user <%=login%> and password <%=password%> has not been registered</p>
<p>the password <%=password%> is too simple</p>

<p><a href=index.jsp>return to the main page</a><p>

</body>
</html>
