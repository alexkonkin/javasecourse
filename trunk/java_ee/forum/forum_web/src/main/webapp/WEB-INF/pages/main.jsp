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
    <style>
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 8px;
            width: 350px;
            height: 50px;
            overflow:auto;
        }
    </style>
</head>
<body>
<h3>Forum's main page</h3>
<br>

<c:if test="${error}">
    <div class="errorblock">
        Your login attempt was not successful, try again.<br /> Caused :
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if>

<form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='j_username' /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password'></td>
        </tr>
        <tr>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Click to register">&nbsp;<input name="reset" type="reset"></td>
        </tr>
    </table>
</form>


<p>
<a href="<c:url value="http://localhost:8181/register"/>">Don't have user account?Click here to register</a>
<p>
<!--c:out value="login is : ${sessionScope.userCredentials.login}"/><br-->
<!--c:out value="password is : ${sessionScope.userCredentials.password}"/-->

<c:if test="${isAuthenticated}">
    <c:out value="User ${sessionScope.userCredentials.login} logged in."/> <a href="<c:url value="http://localhost:8181/logout"/>">Logout</a><br>
</c:if>


<table border="1">
    <tr>
        <th>Topic name</th><th>Topic owner</th>
    </tr>
    <c:forEach var="topic" items="${topics}" varStatus="topicLoop">
        <tr>
            <td><a href="<c:url value="http://localhost:8181/topic?topicId=${topic.id}"/>">${topic.name}</a></td>
            <td>${topic.user.login}</td>
         </tr>
    </c:forEach>
        <c:choose>
            <c:when test="${isAuthenticated == true}">
                <tr><td colspan = "2"><a href="<c:url value="http://localhost:8181/newtopic"/>">Create a new topic</a></td></tr>
            </c:when>
            <c:otherwise>
                <tr><td colspan = "2">Please login to create a new topic</td></tr>
            </c:otherwise>
        </c:choose>
</table>

</body>
</html>