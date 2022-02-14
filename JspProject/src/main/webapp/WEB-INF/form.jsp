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
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
    <c:out value="${message}"></c:out>
    	<h1>This is the form page!</h1>
    	
    	<form action="/process" method="POST">
    		<label for="name">Name:</label>
    		<input type="text" name="name">
    		
		   	<label for="email">Email:</label>
    		<input type="text" name="email">
    		
    		<label for="password">Password:</label>
    		<input type="text" name="password">
    	
    		<input class="btn btn-primary" type="submit" value="Submit!">
    	</form>
    	
    	<h1>A brief intro!! <span class="text-danger"><c:out value="${intro}">no intro</c:out></span></h1>
    </div>
</body>
</html>