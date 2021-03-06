<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%-- <%@ page isErrorPage="true" %>  --%>  
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
					<th scope="col">Task</th>
					<th scope="col">Creator</th>
					<th scope="col">Assignee</th>
					<th scope="col">Priority</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${tasks }" var="task">
				<tr>
					<th scope="row"><a href="/task/${task.id }"><c:out value="${task.info }"/></a></th>
					<td><c:out value="${task.creator.firstName }"/></td>
					<td><c:out value="${task.assignee.firstName }"/></td>
					<td><c:out value="${task.priority }"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<a href="/task/new" class="btn btn-warning">Create New Task</a>
	</div>
</body>
</html>