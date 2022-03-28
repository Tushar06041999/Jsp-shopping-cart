<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body bgcolor="#FA8072">
	<h1 align="center">Shopping Cart</h1>
	<table border="1" cellspacing="0" align="center">
		<tr>
			<td>Product Name</td>
			<td>Image</td>
			<td>Product Price</td>
			<td>Product Number</td>
			<td>Total Price</td>
		</tr>
			<tr>
				<td>${cart.product.name}</td>
				<td> <img src="${pageContext.request.contextPath}/img/${cart.product.photo}" width="120"></td>
				<td>${cart.product.price}</td>
				<td>${cart.num}</td>
				<td>${cart.product.price*cart.num}</td>
			</tr>
	</table>
	<div align="left">
		<a href="ListProduct.jsp">Buy More</a>
	</div>


</body>
</html>