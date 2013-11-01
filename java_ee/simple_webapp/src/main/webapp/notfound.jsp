<%--
  Created by IntelliJ IDEA.
  User: oleksiy.konkin
  Date: 10/31/13
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Login to user account</title>
<head>
    <title></title>
</head>
<body>
<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");
%>

<p>the login is : <%=login%></p>
<p>the password is : <%=password%></p>

<p>the user <%=login%> and password <%=password%> is not found in the database</p>

<p><a href=index.jsp>return to the main page</a><p>

</body>
</html>