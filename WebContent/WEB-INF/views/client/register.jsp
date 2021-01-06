<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8" />
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="<c:url value="/resources/css/style-register.css"/>"/>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<base href="${pageContext.servletContext.contextPath}/">
</head>

<body>
	<div class="wrapper">
		<div class="inner">
			<img src="<c:url value="/resources/img/register/image-2.png"/>" alt="" class="image-1" />
			<c:url var="url" value="register.htm" />
			<form:form action="${url}" modelAttribute="userForm" method="POST">
				<h3>New Account?</h3>
				<div class="form-holder">
					<span class="lnr lnr-user"></span> 
					<form:input path="user.name" class="form-control" placeholder="Full Name" />
					<form:errors path="user.name" />
				</div>
				
				<div class="form-holder">
					<span class="lnr lnr-phone-handset"></span> 
					<form:input path="user.phone" class="form-control" placeholder="Phone Number" />
					<form:errors path="user.phone" />
				</div>
				
				<div class="form-holder">
					<span class="lnr lnr-calendar-full"></span> 
					<form:input path="user.birthday" class="form-control" placeholder="Birthday" />
					<form:errors path="user.birthday" />
				</div>
				
				<div class="form-holder">
					<span class="lnr lnr-home"></span> 
					<form:input path="user.address" class="form-control" placeholder="Address" />
					<form:errors path="user.address" />
				</div>
				
				<div class="form-holder">
					<span class="lnr lnr-envelope"></span> 
					<form:input path="user.email" class="form-control" placeholder="Email" />
					<form:errors path="user.email" />
				</div>
				
				<div class="form-holder">
					<span class="lnr lnr-envelope"></span> 
					<form:select path="user.sex" class="form-control">
    					<form:option value="true">Male</form:option>
    					<form:option value="false">Female</form:option>
  					</form:select>
				</div>
				
				<div class="form-holder">
					<span class="lnr lnr-lock"></span> 
					<form:password path="user.password" class="form-control" placeholder="Password" />
					<form:errors path="user.password" />
				</div>
				
				<div class="form-holder">
					<span class="lnr lnr-lock"></span> 
					<form:password path="confirmPassword" class="form-control" placeholder="Confirm Password" />
					<form:errors path="confirmPassword" />
				</div>
				
				<button class="btn btn-success">Register</button>
				<a href="admin/user/index.htm" class="btn btn-danger">Cancel</a>
			</form:form>
			<img src="<c:url value="/resources/img/register/image-1.png"/>" alt="" class="image-1" />
		</div>
	</div>

	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
