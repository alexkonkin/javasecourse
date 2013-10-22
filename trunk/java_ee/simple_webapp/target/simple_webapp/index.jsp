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
<a href="register.jsp" id="register_new_account">Don't have account? Click here to register </a>
<p>
<% Integer hitsCount = (Integer)application.getAttribute("count");
    if( hitsCount ==null || hitsCount == 0 ){
       hitsCount = 1;
    }else{
       hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>
<p>number of visitors <%=hitsCount%>
</body>
</html>
