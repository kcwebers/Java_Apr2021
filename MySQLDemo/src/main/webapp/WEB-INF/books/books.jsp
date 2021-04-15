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
	<div class="container"> <!-- Beginning of Container -->

        
        <h1>This is the Books.jsp</h1>
        
        <h1>All Books</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Title</th>
		            <th>Description</th>
		            <th>Language</th>
		            <th>Number of Pages</th>
	<!-- 	            <th>Author</th> -->
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${books}" var="book">
		        <tr>
		            <td><a href="/books/${book.id }/show"><c:out value="${book.title}"/></a></td>
		            <td><c:out value="${book.description}"/></td>
		            <td><c:out value="${book.language}"/></td>
		            <td><c:out value="${book.numberOfPages}"/></td>
		            
		            
		            <%-- <td><c:out value="${book.author.firstName}"/> <c:out value="${book.author.lastName}"/></td>
		             --%>
		            
		            <td><a href="/books/${book.id}">Edit</a> | 
		            
		            <form action="/books/${book.id}" method="post">
		            	<input type="hidden" name="_method" value="delete">
		            	
		            	<input type="submit" value="Destroy Book">
		            </form>
		            
		            </td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/books/new">New Book</a>
		
		<h1>All Authors</h1>
		<table>
		    <thead>
		        <tr>
		            <th>First Name</th>
		            <th>Last Name</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${authors}" var="auth">
		        <tr>
		            <td><c:out value="${auth.firstName}"/></td>
		            <td><c:out value="${auth.lastName}"/></td>
		            <td><a href="/books/${auth.id}">Edit Authors</a> | 
		            
		            <form action="/author/${auth.id}" method="post">
		            	<input type="hidden" name="_method" value="delete">
		            	
		            	<input type="submit" value="Destroy Author">
		            </form>
		            
		            </td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		
		<a href="/authors/new">New Author</a>
        
        
	</div> <!-- End of Container -->
</body>
</html>