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
<%@page isELIgnored="false"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topic's page</title>
</head>
<body>
<c:out value="This page is dedicated to topic : ${topic.name}"/><br>

<a href="<c:url value="/"/>">return to the main page</a>

</body>
</html>