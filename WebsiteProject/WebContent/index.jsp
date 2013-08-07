<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		Register form:
		<br>
		<form action="RegistrationServlet" method="post">
			<label>Enter your first name: </label>
			<br>
			<input type="textbox" name="firstName">
			<br>
			<label>Enter your last name: </label>
			<br>
			<input type="textbox" name="lastName">
			<br>
			<label>Enter password: </label>
			<br>
			<input type="password" name="password">
			<br>
			<label>Confirm password: </label>
			<br>
			<input type="password" name="confirmPassword">
			<br>
			<input type="submit" value="go">
		</form>
</body>
</html> 