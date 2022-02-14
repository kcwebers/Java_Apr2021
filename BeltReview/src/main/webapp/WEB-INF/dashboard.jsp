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
<!-- button sends us to the route where we clear the session, thus logging hte user out! -->
	<a class="btn btn-danger float-right mt-3" href="/logout">Logout</a>
	<h1>You made it to the dashboard!</h1>
<!-- 	display the user's named, based on how we send the information from the controller to the .jsp via model.addAttribute -->	
	<h2 class="text-info">Welcome <c:out value="${user.firstName}" />!</h2>

<!-- This line catches the 'success' redirect attribute that we sent along when the user registered or logged in! -->
	<p class="text-success"><c:out value="${success}" /></p>
	
	
	<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">Location</th>
      <th scope="col">Date</th>
      <th scope="col">Description</th>
      <th scope="col">Organizer</th>
       <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${all_trips}" var="trip">
    <tr>
      <th scope="row"><a href="/trip/${trip.id }"><c:out value="${trip.location }" /></a></th>
      <td><c:out value="${trip.date }" /></td>
      <td><c:out value="${trip.description }" /></td>
      <td><c:out value="${trip.organizer.firstName }" /> <c:out value="${trip.organizer.lastName }" /></td>
    	<td>
    	<div class="row">
    	<a class="btn btn-light" href="/trip/edit/${trip.id }">Edit</a>  
    	
    	<form class="ml-2" method="post" action="/trip/delete/${trip.id}">  
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" class="btn btn-danger" value="Delete">
    	</form>
    	
    	<a class="ml-2 btn btn-success" href="/trip/join/${trip.id }">Join Tip!</a>
    	</div>
    	
    	
    	</td>
    </tr>
 	</c:forEach>
  </tbody>
</table>

	<form action="/search" method="post">
	<input type="hidden" name="_method" value="put">
		<input type="text" name="search">
		<input type="text" name="change">
		
		<input type="submit" value="Search" class="btn btn-primary">
	</form>
	
	
	
	<a class="btn btn-warning" href="/trip/new">Create New Trip!</a>


	<c:forEach items="${locations }" var = "loc">
		<p><c:out value="${loc.location }"/>- <c:out value="${loc.description }"/></p>
	</c:forEach>


	</div>
</body>
</html>