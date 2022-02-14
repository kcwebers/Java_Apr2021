<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Project</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    	<a href="/logout" class="btn btn-danger mt-2 float-end">Logout</a>
    	<a href="/dashboard" class="btn btn-success mt-2 me-2 float-end">Dashboard</a>
    	<h1>Editing Info for Car No. <span class="text-info"><c:out value="${car.id }"></c:out></span></h1>
    	
    	<form:form action="/update/${car.id }" method="post" modelAttribute="car">
    	<input type="hidden" name="_method" value="put">
	    	<form:hidden path="driver"/>
	    	<div class="form-group">
	            <label>Color:</label>
	            <form:input path="color" class="form-control" />
	            <form:errors path="color" class="text-danger" />
	        </div>
	        <div class="form-group">
	            <label>Number of Seats:</label>
	            <form:input path="numberOfSeats" class="form-control" />
	            <form:errors path="numberOfSeats" class="text-danger" />
	        </div>
    	
    		<input class="btn btn-info mt-2" type="submit" value="Update Car">
    	</form:form>
    	
    	<form action="/delete/${car.id }" method="post">
     		<input type="hidden" name="_method" value="delete">
     		<input type="submit" value="Delete" class="btn btn-danger">
     	</form>
    	
	</div>
</body>
</html>