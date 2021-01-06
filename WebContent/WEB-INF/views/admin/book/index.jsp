<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book | Admin</title>
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
				<h6 class="m-0 font-weight-bold text-primary">Book Table</h6>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<a href="admin/book/insert.htm"
							class="btn btn-success float-right">New book</a>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h3 class="panel-title text-center "></h3>
							</div>
							<div class="panel-body">
								<table class="table table-bordered dataTable">
									<thead>
										<tr >
											<th width="50">ID</th>
											<th width="150">Name</th>
											<th >Author</th>
											<th >Category</th>
											<th >Price</th>
											<th >Amount</th>
											<th width="50">Img</th>
											<th width="250">Detail</th>
											<th width="170">Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="data" items="${datas}">
											<tr class="odd">
												<td>${data.id}</td>
												<td>${data.name}</td>
												<td>${data.author}</td>
												<td>${data.cate.name}</td>
												<td><fmt:formatNumber currencyCode="vi_VN" value="${data.price}" /></td>
												<td>${data.amount}</td>
												<td><div style="height:100px;"><img src="<c:url value="${data.img}" />" alt="product img"></div></td>
												<td><div style="height:100px; overflow-y: scroll; ">${data.detail}</div></td>
												<td><a href="admin/book/update/${data.id}.htm"
													class="btn btn-primary">Edit</a>
													<button class="btn btn-danger deleteBook" type="button" book_id="${data.id}"
														data-toggle="modal" data-target="#myModal">Delete</button>
													<div class="modal" id="myModal">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<h4 class="modal-title">Do you want Delete</h4>
																	<button type="button" class="close"
																		data-dismiss="modal">&times;</button>
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-danger confirmDelete" data-dismiss="modal">Yes</button>
																	<button type="button" class="btn btn-success" data-dismiss="modal">No</button>
																</div>
															</div>
														</div>
													</div>
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
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/main3.js"/>"></script>
</body>
</body>
</html>