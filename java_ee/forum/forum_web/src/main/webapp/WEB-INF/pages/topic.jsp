<%--
  Created by IntelliJ IDEA.
  User: oleksiy.konkin
  Date: 12/20/13
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page isELIgnored="false"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topic's page</title>
</head>
<body>

<p>
    <c:if test="${isAuthenticated}">
    <sec:authorize access="hasRole('ROLE_ADMINISTRATOR')" var="isAdmin"/>
    <sec:authentication property="principal.username" var="spring_username" scope="page"/>
    </c:if>

<table border="1">
    <tr>
        <th>This page is dedicated to topic : ${topic.name}</th><th>Edit</th>
    </tr>
    <c:choose>
        <c:when test="${fn:length(messages) > 0 }">
            <c:forEach var="message" items="${messages}" varStatus="topicLoop">
                <tr>
                    <td>This message was posted by : ${message.user.login}</td>
                    <c:if test="${isAuthenticated}">
                        <c:choose>
                            <c:when test="${isAdmin}">
                                <td><a href="<c:url value="http://localhost:8181/topic/delete/message?topicId=${topic.id}&messageId=${message.id}"/>">delete</a></td>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${message.user.login == spring_username}">
                                    <td><a href="<c:url value="http://localhost:8181/topic/delete/message?topicId=${topic.id}&messageId=${message.id}"/>">delete</a></td>
                                </c:if>
                                <c:if test="${message.user.login != spring_username}">
                                    <td>&nbsp</td>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                    <c:if test="${isAuthenticated == null}">
                        <td>&nbsp</td>
                    </c:if>
                </tr>
                <tr>
                    <td colspan="2">${message.content}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr><td>This thread is empty, please add a first comment</td></tr>
        </c:otherwise>
    </c:choose>
</table>
<p>

<c:choose>
    <c:when test="${isAuthenticated == true}">
        <form:form method="post" action="/topic/addMessage" commandName="message">
            <table>
                <tr>
                    <form:label path="content">post your comment</form:label><br>
                    <form:textarea path="content" />
                    <form:hidden path="topic.id" value="${topic.id}"/>
                    <form:hidden path="topic.name" value="${topic.name}"/>
                    <form:hidden path="user.login" value="${sessionScope.userCredentials.login}"/>
                    <form:hidden path="user.password" value="${sessionScope.userCredentials.password}"/>
                    <form:hidden path="user.id" value="${sessionScope.userCredentials.id}"/>
                </tr>
                <tr>
                    <td colspan="2">
                    <td ><input type="submit" value="Add a comment"/></td>
                    </td>
                </tr>
            </table>
        </form:form>
    </c:when>
    <c:otherwise>
    <tr><td>Please login to post a new comment</td></tr>
    </c:otherwise>
</c:choose>
<p>
<a href="<c:url value="/"/>">return to the main page</a>
</body>
</html>