<%--
  Created by IntelliJ IDEA.
  User: oleksiy.konkin
  Date: 1/2/14
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>Register a new user</title>
</head>
<body>
<form:form method="post" action="/register/addUser" commandName="user">
    <table>
        <tr>
            <td><form:label path="login">User's login</form:label></td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td><form:label path="password">User's password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type="submit" value="Register a new user" style="width:100%"/></td>
        </tr>
    </table>
</form:form>
<p>
<c:if test="${fn:length(sessionScope.registerNewUserStringResponse) > 0}">
    <c:out value="${sessionScope.registerNewUserStringResponse}"/><br>
    <c:remove var="registerNewUserStringResponse" scope="session"/>
</c:if>
<p>
<a href="<c:url value="/"/>">return to the main page</a>

</body>
</html>