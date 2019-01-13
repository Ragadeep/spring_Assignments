<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Withdraw Form</h1>
	<form action="withdrawAmmount" method="POST">
		<label>Account Number</label>
		<input name="accountNumber"/><br><br>
		<label>Withdraw Amount</label>
		<input name="accountBalance"/><br><br>
		<input type="submit" value="withdraw">
		<input type="reset" value="Reset">
	</form>
</body>
</html>