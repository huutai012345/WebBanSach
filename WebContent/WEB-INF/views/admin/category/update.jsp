<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin</title>
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
			<c:url var="url" value="admin/category/update.htm" />
			<form:form action="${url}" modelAttribute="category" method="POST"
				class="form-horizontal">
				<fieldset>
					<div id="legend">
						<legend class="">Edit Form</legend>
					</div>
					<div class="control-group">
						<label class="control-label">ID</label>
						<div class="controls">
							<form:input path="id" class="input-xlarge" readonly="true"/>
							<form:errors path="id" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Name</label>
						<div class="controls">
							<form:input path="name" class="input-xlarge" />
							<form:errors path="name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Description</label>
						<div class="controls">
							<form:input path="description" class="input-xlarge" />
							<form:errors path="description" />
						</div>
					</div>
					<div class="control-group">
						<!-- Button -->
						<div class="controls">
							<button class="btn btn-success">Edit</button>
							<a href="admin/category/update/${category.id}.htm" class="btn btn-warning">Reset</a>
							<a href="admin/category/index.htm" class="btn btn-danger">Back</a>
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