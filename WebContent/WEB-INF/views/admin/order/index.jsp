<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="<c:url value="/resources/css/admin.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css" />
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<jsp:include page="../nav.jsp" />
	<div class="content-container">
		<jsp:include page="../header.jsp" />
		<div class="container-fluid">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Order Table</h6>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h3 class="panel-title text-center "></h3>
							</div>
							<div class="panel-body">
								<table class="table table-bordered dataTable">
									<thead>
										<tr role="row">
											<th width="50" style="text-align: center;">ID</th>
											<th style="text-align: center;">ID User</th>
											<th style="text-align: center;">User Name</th>
											<th width="150" style="text-align: center;">Payment</th>
											<th width="150" style="text-align: center;">Created At</th>
											<th width="100" style="text-align: center;">Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="data" items="${datas}">
											<tr class="odd">
												<td align="center">${data.id}</td>
												<td align="center">${data.user.id}</td>
												<td align="center">${data.user.name}</td>
												<td align="center">${data.status==true?"Paid":"Unpaid"}</td>
												<td align="center">${data.created_at}</td>
												<td align="center">
													<a href="admin/order-detail/index/${data.id}.htm" class="btn btn-primary">Detail</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	${message}
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</body>
</html>