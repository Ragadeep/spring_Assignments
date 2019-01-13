
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Account Details</h1>
	<form action="updateAccountDetails">
		<label>Account Number</label>
		<input type="text" name="accountNumber" readonly="readonly" value="${account.bankAccount.accountNumber}"><br><br>
		<label>AccountHolderName</label>
		<input type="text" name="accountHolderName" value="${account.bankAccount.accountHolderName}"><br><br>
		<label>Account Balance</label>
		<input type="text" name="accountBalance" readonly="readonly" value="${account.bankAccount.accountBalance}"><br><br>
		<label>salary</label>
		<input type="radio" name="salary" value="Yes" ${account.salary==true?"checked":""}>Yes
		<input type="radio" name="salary" value="No" ${account.salary==true?"":"checked"}>No<br><br>
		<input type="submit" value="Update Account">
		<input type="reset" value="Reset">
	</form>
</body>
</html>