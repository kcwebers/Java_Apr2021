<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%-- <%@ page isErrorPage="true" %>  --%>    
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
		<div class="row">
			<div class="col">

				<p class="text-danger">
					<c:out value="${please}" />
				</p>

				<h1>Register!</h1>
				<!-- This is handling all of our errors at once instead of separating them out in our form
    Both methods of error handling are acceptable! Whichever you prefer works :) -->
				<p>
					<form:errors class="text-danger" path="user.*" />
				</p>

				<%-- The 'modelAttribute' in our <form:form> is coming from our controllers
    Note that we don't need to user <c:out> when working inside of a tag, only when working outside! --%>
				<form:form class="form-group push" method="POST"
					action="/registration" modelAttribute="user">
					<%--Make sure the `path="something"` matches your fields in you Model EXACTLY
        This rule applies to all <form:form> type forms --%>
					<p>
						<form:label path="firstName">First Name:</form:label>
						<form:input type="text" path="firstName" />
					</p>
					<p>
						<form:label path="lastName">Last Name:</form:label>
						<form:input type="text" path="lastName" />
					</p>
					<p>
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email" />
					</p>
					<p>
						<form:label path="password">Password:</form:label>
						<form:password path="password" />
					</p>
					<p>
						<form:label path="passwordConfirmation">Password Confirmation:</form:label>
						<form:password path="passwordConfirmation" />
					</p>
					<input class="btn btn-success mt-3" type="submit" value="Register!" />
				</form:form>
			</div>
			<!-- end of Register column -->

			<div class="col">

				<h1>Login</h1>

				<!-- instead of catching our error message through form:form, we sent our error message via the redirectAttributes in the login route -->
				<p class="text-danger">
					<c:out value="${error}" />
				</p>

				<!-- fior login, we use a regular form because we are only working with the email/password (not the while model) -->
				<form method="post" action="/login">
					<p>
						<label for="email">Email</label> <input type="text" id="email"
							name="email" />
					</p>
					<p>
						<label for="password">Password</label> <input type="password"
							id="password" name="password" />
					</p>
					<input class="btn btn-warning mt-3" type="submit" value="Login!" />
				</form>

			</div>
			<!-- end of Login form column -->
		</div>
		<!-- end of Row -->
	</div>
	<!-- End of Container -->
</body>
</html>

