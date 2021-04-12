<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Whale Hello There!!</h1>
	
	<h3><c:out value="${name}"/></h3>
	<p><c:out value="${pass}"/></p>
	
	<form method="POST" action="/login">
	    <label>Username: <input type="text" name="username"></label>
	    <label>Password: <input type="text" name="password"></label>
	    <button>Login</button>
	</form>
	
	
	<p><c:out value="${count}"/></p>
	

</body>
</html>