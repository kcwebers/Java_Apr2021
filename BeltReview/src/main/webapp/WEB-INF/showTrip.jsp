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
	<h1>Showing info for Trip No. <span class="text-info"><c:out value="${trip.id }" /></span></h1>

	<h3>Location :<span class="text-info"><c:out value="${trip.location }" /></span></h3>
	<h3>Date : <span class="text-info"><c:out value="${trip.date }" /></span></h3>
	<h3>Destination : <span class="text-info"><c:out value="${trip.description }" /></span></h3>
	<h3>Organizer : <span class="text-info"><c:out value="${trip.organizer.firstName }" /> <c:out value="${trip.organizer.lastName }" /></span></h3>
	<h3>Attendees : </h3>
		<c:forEach items="${trip.attendees }" var="attendee">
			<p><span class="text-info"><c:out value="${attendee.firstName }" /> <c:out value="${attendee.lastName }" /></span></p>
		</c:forEach>

	</div>
</body>
</html>