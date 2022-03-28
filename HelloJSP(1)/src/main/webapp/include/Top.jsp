<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top</title>
</head>
<body>
<h1 align="center">JSP Online Shopping</h1>

	<c:if test="${empty user }">
		<a href="Login.jsp">Login</a>
	</c:if>

	<c:if test="${!empty user }">
		<h2 align="center" >Welcome ${user.name}</h2>
		<a href="Logout.jsp">Logout</a>
	</c:if>
	<hr><br>
</body>
</html>