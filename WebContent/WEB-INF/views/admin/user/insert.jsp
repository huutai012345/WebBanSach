<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Book | Admin</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/admin.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous" />
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css" />
</head>
<base href="${pageContext.servletContext.contextPath}/">
<body>
	<jsp:include page="../nav.jsp" />
	<div class="content-container">
		<jsp:include page="../header.jsp" />
		<div class="container-fluid">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">FORM</h6>
			</div>
			<c:url var="url" value="admin/user/insert.htm" />
			<form:form action="${url}" modelAttribute="userForm" method="POST"
				class="form-horizontal">
				<fieldset>
					<div id="legend">
						<legend class="">Insert User</legend>
					</div>
					<div class="control-group">
						<!-- Username -->
						<label class="control-label">Name</label>
						<div class="controls">
							<form:input path="user.name" class="input-xlarge" />
							<form:errors path="user.name" />
						</div>
					</div>

					<div class="control-group">
						<!-- E-mail -->
						<label class="control-label">E-mail</label>
						<div class="controls">
							<form:input path="user.email" class="input-xlarge" />
							<form:errors path="user.email" />

						</div>
					</div>

					<div class="control-group">
						<!-- Birthday -->
						<label class="control-label">Birthday</label>
						<div class="controls">
							<form:input path="user.birthday" class="input-xlarge" />
							<form:errors path="user.birthday" />
						</div>
					</div>

					<div class="control-group">
						<!-- Address -->
						<label class="control-label">Address</label>
						<div class="controls">
							<form:input path="user.address" class="input-xlarge" />
							<form:errors path="user.address" />
						</div>
					</div>
					
					<div class="control-group">
						<!-- Address -->
						<label class="control-label">Phone</label>
						<div class="controls">
							<form:input path="user.phone" class="input-xlarge" />
							<form:errors path="user.phone" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">Sex</label>
						<div class="controls">
							<div class="custom-control custom-radio custom-control-inline">
								<form:radiobutton path="user.sex" value="1" label="Male" />
							</div>

							<div class="custom-control custom-radio custom-control-inline">
								<form:radiobutton path="user.sex" value="0" label="Female" />
							</div>
						</div>
					</div>
					
					<div class="control-group">
						<!-- Password-->
						<label class="control-label">Password</label>
						<div class="controls">
							<form:password path="user.password" class="input-xlarge" />
							<form:errors path="user.password" />
						</div>
					</div>
					
					<div class="control-group">
						<!-- Password-->
						<label class="control-label">Confirm Password</label>
						<div class="controls">
							<form:password path="confirmPassword" class="input-xlarge" />
							<form:errors path="confirmPassword" />
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">Role</label>
						<div class="controls">
							<div class="custom-control custom-radio custom-control-inline">
								<form:radiobutton path="user.role" value="admin" label="Admin" />
							</div>

							<div class="custom-control custom-radio custom-control-inline">
								<form:radiobutton path="user.role" value="guest" label="Guest" />
							</div>
						</div>
					</div>
					
					<div class="control-group">
						<!-- Button -->
						<div class="controls">
							<button class="btn btn-success" type="submit">Register</button>
							<a href="admin/user/insert.htm" class="btn btn-warning">Reset</a>
							<a href="admin/user/index.htm" class="btn btn-danger">Back</a>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
	${message}
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script
		src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>
</html>