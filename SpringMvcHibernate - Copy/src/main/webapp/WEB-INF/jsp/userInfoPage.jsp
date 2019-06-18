<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body>
  <jsp:include page="userHeader.jsp" />
 
 
    <h1>Message : ${username}</h1>
<!--     <h2>Select Action to perform</h2>
<a href="save">Add Customer</a></br>
<a href="modify">Update Customer</a></br>
<a href="remove">Delete Customer</a></br>
<a href="viewOne">View Customer by Id</a></br>
<a href="viewAll">View All Customer</a> -->
    
</body>
</html>