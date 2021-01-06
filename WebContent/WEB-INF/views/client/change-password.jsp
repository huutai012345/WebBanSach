<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Bookshop</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Favicons -->
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="apple-touch-icon" href="images/icon.png">

<!-- Google font (font-family: 'Roboto', sans-serif; Poppins ; Satisfy) -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,600i,700,700i,800"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900"
	rel="stylesheet">

<!-- Stylesheets -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/plugins.css"/>">

<!-- Cusom css -->
<link rel="stylesheet" href="<c:url value="/resources/css/custom.css"/>">

<!-- Modernizer js -->
<script
	src="<c:url value="/resources/js/vendor/modernizr-3.5.0.min.js"/>"></script>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<!--[if lte IE 9]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
	<![endif]-->

	<!-- Main wrapper -->
	<div class="wrapper" id="wrapper">
		<!-- Header -->
		<jsp:include page="./header.jsp" />
		<!-- //Header -->
		<!-- Start Bradcaump area -->
		<div class="ht__bradcaump__area bg-image--1">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="bradcaump__inner text-center">
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Bradcaump area -->
		<section class="my_account_area pt--80 pb--55 bg--white">
			<div class="container">
				<div class="row">
					<div class="col-lg-10">
						<div class="my__account__wrapper">
							<h3 class="account__title">Change Password</h3>
							${message}
							<c:url var="url" value="change-password.htm" />
							<form:form action="${url}" method="POST">
								<div class="account__form">
									<div class="input__box">
										<label>Password</label> 
										<input type="password" name="password"> 
									</div>
									<div class="input__box">
										<label>New Password</label> 
										<input type="password" name="newPassword"> 
									</div>
									<div class="input__box">
										<label>Confirm New Password</label> 
										<input type="password" name="newCPassword"> 
									</div>
									<div class="form__btn">
										<button name="btnConfirm">Confirm</button>
										<button name="btnCancel">Cancel</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</section>
		<jsp:include page="./footer.jsp" />
		<!-- END QUICKVIEW PRODUCT -->
	</div>
	<!-- //Main wrapper -->
	 <c:if test = "${message != null}">
         <script>alert("${message}")</script>
     </c:if>
	<!-- JS Files -->
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/plugins.js"/>"></script>
	<script src="<c:url value="/resources/js/active.js"/>"></script>
</body>
</html>