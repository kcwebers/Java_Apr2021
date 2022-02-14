  <!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regular Form</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
	
		<h1>New Book for the Normies</h1>
		
		<form action="/regularForm/process" method="post">
			<small class="text-danger"><c:out value="${terror}" /></small>
			<p>
				<label id="title">Title: </label>
				<input type="text" name="title" >
			</p>
			<small class="text-danger"><c:out value="${derror}" /></small>
			<p>
				<label id="desc">Description: </label>
				<textarea name="desc"></textarea>
			</p>
			<small class="text-danger"><c:out value="${lerror}" /></small>
			<p>
				
				<label id="lang">Language: </label>
				<input type="text" name="lang" >
			</p>
			<small class="text-danger"><c:out value="${nerror}" /></small>
			<p>
				
				<label id="numba"># of Pages: </label>
				<input type="number" name="numba" value="0">
			</p>

			<input class="btn btn-primary mt-2" type="submit" value="Submit" />
		</form>
		
	</div>




</body>
</html>