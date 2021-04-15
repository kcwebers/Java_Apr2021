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
<title>MySQL Demo</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	
	<h1>This works!!</h1>
	<p><c:out value="${book.id }"/></p>
	<p><c:out value="${book.title }"/></p>
	<p><c:out value="${book.description }"/></p>
	<p><c:out value="${book.language }"/></p>
	<p><c:out value="${book.numberOfPages }"/></p>
	<h3>Authors of Book:</h3>
	<c:forEach items="${book.authors }" var="author">
		<p><c:out value="${author.firstName}"/> <c:out value="${author.lastName}"/></p>
	</c:forEach>
	
	
	<form action="/books/addAuthor" method="post">
		<input type="hidden" value="${book.id}" name="book_id">
	
		<select name="author_id">
			<c:forEach items="${authors}" var="author">
				<option value="${author.id}">
					<c:out value="${author.firstName}" />
					<c:out value="${author.lastName}" />
				</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add Author!">
	</form>
	
	</div>

</body>
</html>