<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
	<h1>Create New Account</h1>
	<spring:form action="createAccount" method="POST" modelAttribute="accounts">
		<label>AccountHolderName</label>
		<spring:input path="bankAccount.accountHolderName"/><spring:errors path="bankAccount.accountHolderName" cssClass="error"/><br><br>
		<label>Account Balance</label>
		<spring:input path="bankAccount.accountBalance"/><spring:errors path="bankAccount.accountBalance" cssClass="error"/><br><br>
		<label>salary</label>
		<input type="radio" name="salary" value="yes">Yes
		<input type="radio" name="salary" value="no">No<br><br>
		<input type="submit" value="Create Account">
		<input type="reset" value="Reset">
	</spring:form>
</body>
</html>