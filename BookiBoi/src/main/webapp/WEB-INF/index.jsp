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
<title>Title Here</title>
  <!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="/css/style.css"/>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <h1>You added a db successfully!!</h1>
        
        <form action="/processFavorite" method="post">
               	<select name="book_id">
		        <c:forEach var="book" items="${books }">
		        	<option value="${book.id }">
						<c:out value="${book.title}"></c:out>
					</option>
	        	</c:forEach>
		        </select>
        
        	 	<select name="author_id">
		        <c:forEach var="author" items="${authors }">
		        	<option value="${author.id }">
						<c:out value="${author.firstName}"></c:out> <c:out value="${author.lastName}"></c:out>
					</option>
	        	</c:forEach>
		        </select>
        	<input type="submit" class="btn btn-info" value="Add Favorite!">
        </form>
        
        <c:forEach var="book" items="${books}">
        	<h2><c:out value="${book.title}"></c:out></h2>
        	<p>Number of Pages: <c:out value="${book.numberOfPages}"></c:out></p>
        	<p>Written in: <c:out value="${book.language}"></c:out></p>
        	<p>Description: <c:out value="${book.description}"></c:out></p>
        	<p>Author: <c:out value="${book.author.firstName}"></c:out> <c:out value="${book.author.lastName}"></c:out></p>
        	
        	
        	<form action="/delete/${book.id}" method="post">
        		<input type="hidden" name="_method" value="delete">
        		<input class="btn btn-danger" type="submit" value="Delete">
        	</form>
        	
        	
        	
        	
        </c:forEach>
        
        
        
    </div> <!-- End of Container -->
</body>
</html>
