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
    	<h1>Showing Info for Car No. <span class="text-info"><c:out value="${car.id }"></c:out></span></h1>
    	
    	<h3>Color: <span class="text-info"><c:out value="${car.color }"></c:out></span></h3>
    	<h3>Number of Seats: <span class="text-info"><c:out value="${car.numberOfSeats }"></c:out></span></h3>
    	<h3>Driver: <span class="text-info"><c:out value="${car.driver.firstName }"></c:out></span></h3>
    
		<a href="/edit/${car.id }" class="btn btn-primary">Edit</a>
     	<form action="/delete/${car.id }" method="post">
     		<input type="hidden" name="_method" value="delete">
     		<input type="submit" value="Delete" class="btn btn-danger">
     	</form>
    
    </div>
</body>
</html>