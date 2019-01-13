<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Search Account</h1>
	<spring:form action="searchAccount" method="POST"  modelAttribute="accounts">
		Enter Account Number: <spring:input path="bankAccount.accountNumber"/>
		<br/> <input type="submit" value="Submit">
	</spring:form>
</body>
</html>