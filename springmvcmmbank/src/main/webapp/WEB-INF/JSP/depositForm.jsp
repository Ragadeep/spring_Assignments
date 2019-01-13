<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Deposit Form</h1>
	<form action="depositAmount" method="POST">
		<label>Account Number</label>
		<input name="accountNumber"/><br><br>
		<label>Depositing Ammount</label>
		<input name="accountBalance"/><br><br>
		<input type="submit" value="Deposit">
		<input type="reset" value="Reset">
	</form>
</body>
</html>