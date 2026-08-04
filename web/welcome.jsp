<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<title>Welcome</title>
</head>

<body>

<%

// request object
String course=(String)request.getAttribute("course");

// session object
String username=(String)session.getAttribute("myusr");

// application object
Integer visitors=(Integer)application.getAttribute("visitorCount");

// pageContext object
pageContext.setAttribute("courseName","Advanced Java");

// config object
String college=config.getServletContext()
.getInitParameter("collegeName");

%>

<h2>Welcome <%=username%></h2>

<hr>

<h3>Application Visitors : <%=visitors%></h3>

<h3>College : <%=college%></h3>

<h3>Course : <%=course%></h3>

<h3>PageContext Course :
<%=pageContext.getAttribute("courseName")%></h3>

<h3>JSP Class :
<%=page.getClass().getName()%></h3>

<a href="LogoutServlet">Logout</a>

</body>

</html>