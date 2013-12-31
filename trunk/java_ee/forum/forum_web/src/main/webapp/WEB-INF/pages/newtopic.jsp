<%--
  Created by IntelliJ IDEA.
  User: oleksiy.konkin
  Date: 12/31/13
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>Create a new topic</title>
</head>
<body>
<c:out value="Hello, ${sessionScope.userCredentials.login}"/>
<p>
<form:form method="post" action="/newtopic/addTopic" commandName="topic">
    <table>
        <tr>
            <form:label path="name">Topic name</form:label><br>
            <form:input path="name"/>
            <form:hidden path="user.login" value="${sessionScope.userCredentials.login}"/>
            <form:hidden path="user.password" value="${sessionScope.userCredentials.password}"/>
            <form:hidden path="user.id" value="${sessionScope.userCredentials.id}"/>
        </tr>
        <tr>
            <td colspan="2">
            <td ><input type="submit" value="Add a topic to the forum"/></td>
            </td>
        </tr>
    </table>
</form:form>
<p>


<a href="<c:url value="/"/>">return to the main page</a>
</body>
</html>