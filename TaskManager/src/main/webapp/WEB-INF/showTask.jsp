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
	<h1>Task: <span class="text-primary"><c:out value="${task.info }"/></span></h1>
	
	<h3>Creator: <span class="text-primary"><c:out value="${task.creator.firstName }"/></span></h3>
	<h3>Assignee: <span class="text-primary"><c:out value="${task.assignee.firstName }"/></span></h3>
	<h3>Priority: <span class="text-primary"><c:out value="${task.priority }"/></span></h3>

	<a href="/task/${task.id }/edit" class="btn btn-warning">Edit Task</a>

	<form action="/task/${task.id }/delete" method="post">
		<input type="hidden" value="delete" name="_method">
		<input type="submit" class="btn btn-danger" value="Delete Task">
	</form>
	</div>
</body>
</html>