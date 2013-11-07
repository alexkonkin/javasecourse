<%@ page import="com.globallogic.javase.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
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
    <title>Login to user account</title>
</head>
<body>

<c:set var="login" scope="session" value="${sessionScope.aUserRegistrationInfo.login}"/>
<c:set var="password" scope="session" value="${sessionScope.aUserRegistrationInfo.password}"/>
<p> the login is : <c:out value="${login}"/>
<p> the password is : <c:out value="${password}"/>
<p> the user <c:out value="${login}"/> with the password <c:out value="${password}"/> logged in to the system<p>

<p>List of the users that are present in the system storage:
<c:set var="arr" scope="session" value="${sessionScope.arr}"/>
   <table border="1">
   <c:forEach var="user" items="${sessionScope.arr}">
       <tr>
       <th><c:out value="${user.login}"/></th><th><c:out value="${user.password}"/></th>
       </tr>
    </c:forEach>
   </table>
<p><a href=index.jsp>return to the main page</a><p>

</body>
</html>