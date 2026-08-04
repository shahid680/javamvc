<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<title>Login</title>
</head>

<body>

<h2>Login Page</h2>

<form action="loginservlet" method="post">

Username

<input type="text" name="usr">

<br><br>

Password

<input type="password" name="pswd">

<br><br>

<input type="submit" value="Login">

</form>

<%

String error=(String)request.getAttribute("error");

if(error!=null)
{

out.println("<font color='red'>"+error+"</font>");

}

%>

</body>

</html>