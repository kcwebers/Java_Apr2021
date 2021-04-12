<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
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
<!-- ... -->
<form method="POST" action="/login">
    <label>Username: <input type="text" name="username"></label>
    <label>Password: <input type="password" name="password"></label>
    <button class="btn btn-dark" type="submit">Login</button>
</form>
<!-- ... -->

     <h1>Hello There! <span class="text-danger"><c:out value="${newName}"/>
        </span></h1>
     <h1>Here's your password:<span class="text-danger"><c:out value="${pass}"/>
        </span></h1>
</body>
</html>