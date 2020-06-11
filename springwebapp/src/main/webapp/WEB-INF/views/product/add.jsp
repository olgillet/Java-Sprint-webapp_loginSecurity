<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<title>Product</title>
		<style type="text/css">
		.error{
			color: red;
		}
		</style>
	</head>
	<body>
	<h1>Page - Product - add</h1>
	<br/>
	<form:form method="POST" action="" modelAttribute="productObject">
		<spring:hasBindErrors name="productObject">
			<div class="error">
				<h2>Error(s)</h2>
			</div>
		</spring:hasBindErrors>
	
		<form:label path="name">Product name : </form:label>
		<form:input path="name" placeholder="ex: Default product name"/>
			<spring:hasBindErrors name="productObject">
				<form:errors path="name" cssClass="error"/>
			</spring:hasBindErrors>
		<br/>
		
		<form:label path="unitPrice">Unit price : </form:label>
		<form:input path="unitPrice"/>
			<spring:hasBindErrors name="productObject">
				<form:errors path="unitPrice" cssClass="error"/>
			</spring:hasBindErrors>
		<br/>
		
		<button type="submit">Add a product</button>
		
	</form:form>
	
	</body>
</html>