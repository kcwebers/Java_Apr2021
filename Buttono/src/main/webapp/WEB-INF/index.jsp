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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

    <div class="container bg-${bgcolor}"> <!-- Beginning of Container -->
        <a href="/clear" class="mt-2 btn btn-dark">Reset!</a>
        <h1>Please select your color!</h1>
        
        <a href="/danger" class="btn btn-danger mt-2">Red</a>
        <a href="/warning" class="btn btn-warning mt-2 ml-2">Yellow</a>
        <a href="/primary" class="btn btn-primary mt-2 ml-2">Blue</a>
        <a href="/info" class="btn btn-info mt-2 ml-2">Teal</a>
        <a href="/success" class="btn btn-success mt-2 ml-2">Green</a>
        <a href="/secondary" class="btn btn-secondary mt-2 ml-2">Grey</a>
    </div> <!-- End of Container -->
    
</body>
</html>
