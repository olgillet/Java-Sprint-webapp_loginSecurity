<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
	<h1>Page - User - login</h1>
	<br/>
	<form:form method="POST" action="" modelAttribute="userObject">
		<spring:hasBindErrors name="userObject">
			<div class="error">
				<h2>Error(s)</h2>
			</div>
		</spring:hasBindErrors>
	
		<form:label path="name">User name : </form:label>
		<form:input path="name" placeholder="ex: Default user name"/>
			<spring:hasBindErrors name="userObject">
				<form:errors path="name" cssClass="error"/>
			</spring:hasBindErrors>
		<br/>
		
		<form:label path="password">Password : </form:label>
		<form:input path="password"/>
			<spring:hasBindErrors name="userObject">
				<form:errors path="password" cssClass="error"/>
			</spring:hasBindErrors>
		<br/>
		
		<button type="submit">Login</button>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
	</form:form>
	
	</body>
</html>