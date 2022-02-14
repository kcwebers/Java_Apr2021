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

</head>
<body>
    <div class="container">
        
		<h1>New Book</h1>
		<form:form action="/create" method="post" modelAttribute="banana">
		    <p>
		        <form:label path="title">Title</form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
			</p>
		    <p>
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:textarea path="description"/>
		    </p>
		   	<p>
		        <form:label path="language">Language</form:label>
		        <form:errors path="language"/>
		        <form:textarea path="language"/>
		    </p>
		    <p>
		        <form:label path="numberOfPages">Pages</form:label>
		        <form:errors path="numberOfPages"/>     
		        <form:input type="number" path="numberOfPages"/>
		    </p>
		    <p>
		        <form:label path="author">Author</form:label>
		        <form:errors path="author"/>     
		        <form:select path="author">
			        <c:forEach var="author" items="${authors }">
			        	<form:option value="${author.id }">
							<c:out value="${author.firstName}"></c:out> <c:out value="${author.lastName}"></c:out>
						</form:option>
		        	</c:forEach>
		        </form:select>
		    </p>    
		    <input type="submit" value="Submit"/>
		</form:form>
		
		<p><c:out value ="${authors }"></c:out></p>
		
	</div>
</body>
</html>