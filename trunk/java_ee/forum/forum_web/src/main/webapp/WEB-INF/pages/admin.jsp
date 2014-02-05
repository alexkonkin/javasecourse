<%--
  Created by IntelliJ IDEA.
  User: oleksiy.konkin
  Date: 1/28/14
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Forum administrator's web page</title>
</head>
<body>

<h4>Users administration page</h4>
<p>
<table border="1">
<tr>
    <th>Login</th><th>Password</th><th>Account status</th><th>Operation</th>
</tr>
<c:forEach var="user" items="${users}" varStatus="userLoop">
    <tr>
        <td>${user.login}</td>
        <td>${user.password}</td>
        <td>
            <c:if test="${user.enabled == true}">
                enabled
            </c:if>
            <c:if test="${user.enabled == false}">
                disabled
            </c:if>
        </td>
        <td>
            <c:if test="${user.login != 'admin'}">
                <c:if test="${user.enabled == true}">
                    <a href="<c:url value="http://localhost:8181/admin/manage?isEnabled=false&userId=${user.id}"/>">disable</a>
                </c:if>
                <c:if test="${user.enabled == false}">
                    <a href="<c:url value="http://localhost:8181/admin/manage?isEnabled=true&userId=${user.id}"/>">enable</a>
                </c:if>
                </c:if>
            <c:if test="${user.login == 'admin'}">
                    &nbsp
            </c:if>
        </td>
    </tr>
</c:forEach>
</table>

<p>
    <a href="<c:url value="/"/>">return to the main page</a>
</body>

</body>
</html>