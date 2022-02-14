<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
    
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    
</head>
<body>
	<div class="container">
	<a class="mt-3 float-right btn btn-dark" href="/dashboard">Home Page</a>
	<h1>Please create a new Trip!!</h1>
		<form:form action="/trip/new" method="post" modelAttribute="trip">
		        <form:errors class="text-danger" path="location"/>
		    <p>
		        <form:label path="location">Location</form:label>
		        <form:input path="location"/>
		    </p>
		        <form:errors class="text-danger" path="description"/>
		    <p>
		        <form:label path="description">Description</form:label>
		        <form:textarea path="description"/>
		    </p>
		        <form:errors class="text-danger" path="date"/>
		    <p>
		        <form:label path="date">Date</form:label>
		        <form:input type="date" path="date"/>
		    </p>
		    <form:hidden value="${userId}" path="organizer"></form:hidden>
		    <input class="btn btn-warning" type="submit" value="Create Trip"/>
		</form:form>
	
	</div>
</body>
</html><