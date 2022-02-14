<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
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
    
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    
</head>
<body>
	<div class="container">

		<h1>Edit Task <span class="text-primary"><c:out value="${task.info }"/></span>!</h1>
		
		<form:errors class="text-danger" path="task.*" />
		<form:form action="/task/${task.id }/edit" method="post" modelAttribute="task">
		<input value="put" name="_method" type="hidden">
			<p>
				<form:label path="info"> Task: </form:label>
				<form:input type="text" path="info" />
			</p>
			<p>
				<form:label path="assignee"> Assignee: </form:label>
				<form:select path="assignee">
					<c:forEach items="${users }" var="user">
						<form:option value="${user.id }"><c:out value="${user.firstName }" /> <c:out value="${user.lastName }" /></form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="priority"> Priority: </form:label>
				<form:select path="priority">
						<form:option value="High">High</form:option>
						<form:option value="Medium">Medium</form:option>
						<form:option value="Low">Low</form:option>
				</form:select>
			</p>
			<form:hidden value="${userId }" path="creator" />
			<input type="submit" class="btn btn-primary" value="Update Task!">
		</form:form>
		
	</div>
</body>
</html>