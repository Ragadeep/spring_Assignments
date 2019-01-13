<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th><a href="sortByNumber">Account Number</a></th>
			<th><a href="sortByName">Holder Name</a></th>
			<th><a href="sortByBalance">Account Balance</a></th>
			<th><a href="sortBySalary">Salary</a></th>
			<th>Over Draft Limit</th>
			<th>Type Of Account</th>
		</tr>
		
		<jstl:if test="${account!=null}">
			<tr>
				<td>${account.bankAccount.accountNumber}</td>
				<td>${account.bankAccount.accountHolderName }</td>
				<td>${account.bankAccount.accountBalance}</td>
				<td>${account.salary==true?"Yes":"No"}</td>
				<td>${"N/A"}</td>
				<td>${"Savings"}</td>
			</tr>
		</jstl:if>
		
		<jstl:if test="${accounts!=null}">
			<jstl:forEach var="accounts" items="${accounts}">
				<tr>
					<td>${accounts.bankAccount.accountNumber}</td>
					<td>${accounts.bankAccount.accountHolderName }</td>
					<td>${accounts.bankAccount.accountBalance}</td>
					<td>${accounts.salary==true?"Yes":"No"}</td>
					<td>${"N/A"}</td>
					<td>${"Savings"}</td>
				</tr>
			</jstl:forEach>
		</jstl:if>
	</table>
</body>
</html>







