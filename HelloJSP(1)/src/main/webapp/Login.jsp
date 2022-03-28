<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
.reg{
height:80px;
width:120px;
background-color:white;
text-decoration:none;
margin-left:8px;
border:2px solid white;
border-radius:5px;
}
.reg:hover{
background-color:black;
color:white;
}
.reg:active{
color:red;
}
.reg1:focus{
border-radius:5px;
outline:none;
}
</style>
</head>
<body bgcolor="#FA8072">
<div align="center">
<h1 >Login</h1>
	<form action="Login" method="Get">

		Username:<input type="text" name="uname" /><br />
		<br /> Password:<input type="password" name="pass" /><br />
		<br /> <input type="submit" class="reg1" value="Login" />
		<a href="Registration.JSP" class="reg">Registration</a>

	</form>
	
	</div>
</body>
</html>




