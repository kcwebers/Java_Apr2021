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
<title>Car Project</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    
    <div class="row">
    <p class="text-danger"><c:out value="${login}"></c:out></p>
    <div class="col">
    <h1>Register</h1>
          
    <form:form action="/register" method="post" modelAttribute="newUser">
        <div class="form-group">
            <label>First Name:</label>
            <form:input path="firstName" class="form-control" />
            <form:errors path="firstName" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Last Name:</label>
            <form:input path="lastName" class="form-control" />
            <form:errors path="lastName" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Confirm Password:</label>
            <form:password path="confirm" class="form-control" />
            <form:errors path="confirm" class="text-danger" />
        </div>
        <input type="submit" value="Register" class="btn btn-primary mt-2" />
    </form:form>
    
    </div>
    
    <div class="col">
    
    <h1 >Login</h1>
    <form:form action="/login" method="post" modelAttribute="newLogin">
    <form:errors path="email" class="text-danger" />
    <form:errors path="password" class="text-danger" />
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            
        </div>
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            
        </div>
        <input type="submit" value="Login" class="btn btn-success mt-2" />
    </form:form>
    </div> <!-- end of col -->
    </div> <!-- end of row -->
    </div> <!-- End of Container -->
</body>
</html>