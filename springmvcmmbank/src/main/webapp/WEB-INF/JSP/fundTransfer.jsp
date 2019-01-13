<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Transfer Funds</h1>
	<form action="fundTransfer"  method="POST">
		<label>Sender's Account Number</label>
		<input name="sender"><br><br>
		<label>Receiver's Account Number</label>
		<input name="receiver"><br><br>
		<label>Amount to Transfer</label>
		<input name="amount"><br><br>
		<input type="submit" value="Transfer">
		<input type="reset" value="reset">
	</form>
</body>
</html>