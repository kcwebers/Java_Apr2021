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
    	<a href="logout" class="btn btn-danger mt-2 float-end">Logout</a>
		<h1>Hello, <span class="text-info"><c:out value="${loggedUser.firstName }"></c:out></span>!</h1>
		<p class="text-danger"><c:out value="${driver}"></c:out></p>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Color</th>
			      <th scope="col">Driver</th>
			      <th scope="col">Number of Seats</th>
			      <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="car" items="${cars }">
			    <tr>
			      <th scope="row"><a href="/show/${car.id }"><c:out value="${car.color }"></c:out></a></th>
			      <td><c:out value="${car.driver.firstName }"></c:out></td>
			      <td><c:out value="${car.numberOfSeats }"></c:out></td>
			      <td>
			      	<a href="/edit/${car.id }" class="btn btn-primary">Edit</a>
			      	<form action="/delete/${car.id }" method="post">
			      		<input type="hidden" name="_method" value="delete">
			      		<input type="submit" value="Delete" class="btn btn-danger">
			      	</form>
				  </td>
			    </tr>
			   </c:forEach>
			  </tbody>
			</table>



		<a href="/new" class="btn btn-warning mt-2">Create New Car</a>
	</div> <!-- end of container -->
</body>
</html>