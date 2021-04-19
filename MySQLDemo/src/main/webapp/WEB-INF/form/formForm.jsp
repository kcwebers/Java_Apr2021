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
<title>Form : Form</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
	
		<h1>New Book the Cool Way</h1>
		
		<form:form action="/formForm/process" method="post" modelAttribute="book">
			<p>
				<form:label path="title">Title</form:label>
				<form:errors class="text-danger" path="title" />
				<form:input path="title" />
			</p>
			<p>
				<form:label path="description">Description</form:label>
				<form:errors class="text-danger" path="description" />
				<form:textarea path="description" />
			</p>
			<p>
			
				
				<form:label path="language">Author</form:label>
	        	<form:errors path="language"/> 
	        	   
	        	<form:select path="language">
	        
		        	<form:option value="English">English</form:option>
		        	<form:option value="Spanish">Spanish</form:option>
		        	<form:option value="French">French</form:option>
		        	<form:option value="German">German</form:option>
		        	<form:option value="Chinese">Chinese</form:option>
		        	<form:option value="Korean">Korean</form:option>
		        	<form:option value="Japanese">Japanese</form:option>

	        	</form:select>
			</p>
			<p>
				<form:label path="numberOfPages">Pages</form:label>
				<form:errors class="text-danger" path="numberOfPages" />
				<form:input type="number" path="numberOfPages"/>
			</p>
			<input class="btn btn-primary mt-2" type="submit" value="Submit" />
		</form:form>
	</div>
	
	<div>
	<c:forEach items="${all_books}" var="one_book">
	
		<p><c:out value="${one_book.title }"/></p>
		<p><c:out value="${one_book.description }"/></p>
		<p>=========================================</p>
	</c:forEach>
	</div>

</body>
</html>

