<%@ page import="com.globallogic.javaee.model.Topic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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