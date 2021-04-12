<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div id="hello" class="container"> <!-- Beginning of Container -->
	<h1>Hello there!</h1>
	<form action="/process_click" method="POST">
		
		<input type="hidden" value="red" name="color">
		<input type="submit" class="mt-4 btn btn-danger" value="Red Button">
	
	</form>
	
	<form action="/process_click" method="POST">
		
		<input type="hidden" value="yellow" name="color">
		<input type="submit" class="mt-4 btn btn-warning" value="Yellow Button">
	
	</form>
	
	<form action="/process_click" method="POST">
		
		<input type="hidden" value="green" name="color">
		<input type="submit" class="mt-4 btn btn-success" value="Green Button">
	
	</form>

    </div> <!-- End of Container -->
</body>
</html>