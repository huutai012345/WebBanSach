<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/style-login.css"/>">
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<div class="wrapper">
		<div class="title">Login</div>
		<c:url var="url" value="admin/login.htm" />
		<form:form action="${url}" method="POST">
			<div class="field">
				<input type="text" name="email" required> 
				<label>Email Address</label>
			</div>
			<div class="field">
				<input type="password" name="password"  required> 
				<label>Password</label>
			</div>
			<div class="content">
				<div class="pass-link">
					<a href="send-email">Forgot password?</a>
				</div>
			</div>
			<div class="field">
				<input type="submit" value="Login">
			</div>
			<div class="signup-link">
				Not a member? 
				<a href="register.htm">Signup now</a>
			</div>
			<div class="fail">${message}</div>
		</form:form>
	</div>
</body>
</html>
