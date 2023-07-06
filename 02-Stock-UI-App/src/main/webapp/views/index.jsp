<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${msg }


	<form action="getTotalCost" method="get">
		<table>
			<tr>
				<td>Company Name::</td>
				<td><input type="text" name="companyName"></td>
			</tr>
			<tr>
				<td>Quantity::</td>
				<td><input type="text" name="quantity"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Get Cost"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>

</body>
</html>