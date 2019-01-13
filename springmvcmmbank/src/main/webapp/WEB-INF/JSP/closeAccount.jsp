<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Close Account</h1>
	<p>Enter Account Number to Delete Account</p>
	<spring:form action="closeAccount"  method="POST" modelAttribute="accounts">
		<label>Account Number</label>
		<spring:input path="bankAccount.accountNumber"/> <br><br>
		<input type="submit" value="Close Account">
		<input type="reset" value="Reset">
	</spring:form>
</body>
</html>