<%@ page import="com.globallogic.javaee.model.Topic" %>
<%@ page import="com.globallogic.javaee.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: oleksiy.konkin
  Date: 12/16/13
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.

  insert into topics (ID, NAME) values ( ID_TOPIC_SEQ.nextVal ,  'tales');

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forum's main page</title>
</head>
<body>
<h3>Forum's main page</h3>
<br>

<form:form method="post" action="/register" commandName="user">
    <table>
        <tr>
            <td><form:label path="login">login</form:label></td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td><form:label path="password">password</form:label></td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td colspan="2">
            <td ><input type="submit" value="Submit"/></td>
            </td>
        </tr>
    </table>
</form:form>

<!--c:out value="login is : ${sessionScope.userCredentials.login}"/><br-->
<!--c:out value="password is : ${sessionScope.userCredentials.password}"/-->
<c:if test="${isAuthenticated}">
    <c:out value="User ${sessionScope.userCredentials.login} logged in"/><br>
</c:if>


<table border="1">
    <tr>
        <th>Topic name</th>
    </tr>
    <c:forEach var="topic" items="${topics}" varStatus="topicLoop">
        <tr>
            <td>${topic.name}</td>
         </tr>
    </c:forEach>
</table>

</body>
</html>