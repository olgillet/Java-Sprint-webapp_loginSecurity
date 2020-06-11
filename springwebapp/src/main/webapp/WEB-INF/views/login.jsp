<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>User</title>
		<style type="text/css">
		.error{
			color: red;
		}
		</style>
	</head>
	<body>
		<h1>Page - Login - login</h1>
		<br/>
		<c:if test = "${error == true}">
		    <div class="error">Incorrect login or password</div>
		</c:if>
		<form method="POST">
			User : <input type="text" name="username" value=""/><br/>
			Password :  <input type="password" name="password" value=""/><br/>
			<input type="submit" value="Login"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	
	</body>
</html>