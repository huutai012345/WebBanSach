<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User | Admin</title>
<link rel="stylesheet" href="<c:url value="/resources/css/admin.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" />
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
			${message}
			<c:url var="url" value="admin/book/insert.htm" />
			<form:form action="${url}" method="POST" modelAttribute="bookForm"
				enctype="multipart/form-data" class="form-horizontal">
				<fieldset>
					<div id="legend">
						<legend>Insert Book</legend>
					</div>

					<jsp:include page="./form.jsp" />

					<div class="control-group">
						<!-- Button -->
						<div class="controls">
							<button class="btn btn-success">Insert</button>
							<a href="admin/book/insert.htm" class="btn btn-warning">Reset</a>
							<a href="admin/book/index.htm" class="btn btn-danger">Back</a>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script
		src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>
</html>