<%@ page import="com.globallogic.javaee.RegistrationStatus" %>
<%@ page import="com.globallogic.javaee.UserRegistrationInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<html>
<head>
<title>Simple web application main page</title>
</head>
<body>
<h2>Please register to continue your work with the application</h2>
<h3>Current date is: <%= new java.util.Date() %></h3>

<FORM ACTION="/simple_webapp/loginToUserAccount" METHOD="POST">
    Login:
    <INPUT TYPE="TEXT" NAME="login"><BR>
    Password:
    <INPUT TYPE="TEXT" NAME="password"><BR>
    <INPUT TYPE="SUBMIT" VALUE="Submit">
</FORM>
<p>

<c:set var="login" scope="session" value="${sessionScope.aUserRegistrationInfo.login}"/>
<c:set var="password" scope="session" value="${sessionScope.aUserRegistrationInfo.password}"/>
<c:set var="status" scope="session" value="${sessionScope.aUserRegistrationInfo.registrationStatus}"/>

<c:if test="${status == 'BAD_CREDENTIALS'}" >
    <p>Error:
    <p> the user <c:out value="${login}"/> with password <c:out value="${password}"/> tried to login with the wrong password<p>
</c:if>

<c:if test="${status == 'USER_NOT_FOUND'}" >
    <p>Error:
    <p> the user <c:out value="${login}"/> with password <c:out value="${password}"/> is not found in the database<p>
</c:if>

<p>
<a href="register.jsp" id="register_new_account">Don't have account? Click here to register </a>
<p>

<jsp:useBean id="count"  scope = "application" type="com.globallogic.javaee.Counter" />
<jsp:setProperty name="count" property="counter" value="${1}" />
<jsp:getProperty name="count" property="counter" />

</body>
</html>
