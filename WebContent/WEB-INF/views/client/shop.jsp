<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet"> 
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,600i,700,700i,800" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet"> 

	<!-- Stylesheets -->
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/plugins.css"/>">
	
	<!-- Cusom css -->
    <link rel="stylesheet" href="<c:url value="/resources/css/custom.css"/>">

	<!-- Modernizer js -->
	<script src="<c:url value="/resources/js/vendor/modernizr-3.5.0.min.js"/>"></script>
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
        <!-- Start Shop Page -->
        <div class="page-shop-sidebar left--sidebar bg--white section-padding--lg">
        	<div class="container">
        		<div class="row">
        			<div class="col-lg-3 col-12 order-2 order-lg-1 md-mt-40 sm-mt-40">
        				<div class="shop__sidebar">
        					<jsp:include page="./search.jsp" />
        					<jsp:include page="./category.jsp" />
        					<jsp:include page="./productTag.jsp" />
        				</div>
        			</div>
        			<div class="col-lg-9 col-12 order-1 order-lg-2">
        				<div class="row">
        					<div class="col-lg-12">
								<div class="shop__list__wrapper d-flex flex-wrap flex-md-nowrap justify-content-between">
									<div class="shop__list nav justify-content-center" role="tablist">
			                            <a class="nav-item nav-link active" data-toggle="tab" href="#nav-grid" role="tab"><i class="fa fa-th"></i></a>
			                            <a class="nav-item nav-link" data-toggle="tab" href="#nav-list" role="tab"><i class="fa fa-list"></i></a>
			                        </div>
			                        <p> <c:out value="Showing ${start} – ${end} of ${total}"/> results</p>
			                        <div class="orderby__wrapper">
			                        	
			                        </div>
		                        </div>
        					</div>
        				</div>
        				<div class="tab__container">
	        				<div class="shop-grid tab-pane fade show active" id="nav-grid" role="tabpanel">
	        					<div class="row">
	        						<c:forEach var="data" items="${datas}">
	        						<!-- Start Single Product -->
		        					<div class="product product__style--3 col-lg-4 col-md-4 col-sm-6 col-12">
			        					<div class="product__thumb">
											<a class="first__img" href="single-product/${data.id}.htm">
												<img src="<c:url value="${data.img}" />" alt="	product image">
											</a>
										</div>
										<div class="product__content content--center">
											<h4><a href="single-product/${data.id}.htm">${data.name}</a></h4>
											<ul class="prize d-flex">
												<li><fmt:formatNumber currencyCode="vi_VN" value="${data.price}" /> VND</li>
											</ul>
										</div>
		        					</div>
		        					<!-- End Single Product -->
		        					</c:forEach>
	        					</div>
	        				</div>
        					<div class="shop-grid tab-pane fade" id="nav-list" role="tabpanel">
	        					<div class="list__view__wrapper">
	        						<c:forEach var="data" items="${datas}">
	        						<!-- Start Single Product -->
	        						<div class="list__view mt--40">
	        							<div class="thumb">
	        								<a class="first__img" href="single-product/${data.id}.htm">
	        									<img src="<c:url value="${data.img}" />" alt="product images">
	        								</a>
	        							</div>
	        							<div class="content">
	        								<h2><a href="single-product/${data.id}.htm">${data.name}</a></h2>
	        								<ul class="prize__box">
	        									<li><fmt:formatNumber currencyCode="vi_VN" value="${data.price}" /> VND</li>
	        								</ul>
	        								<p>${data.detail}</p>
	        							</div>
	        						</div>
	        						<!-- End Single Product -->
	        						</c:forEach>
	        					</div>
	        				</div>	
        				</div>
        				<div style="text-align: center; font-size: 15px;">
        					 <c:forEach var = "i" begin = "1" end = "${page}">
        					 	<a href="shop.htm?page=${i}"style="margin-left: 10px">${i}</a>
      						</c:forEach>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
		<jsp:include page="./footer.jsp" />
		<!-- END QUICKVIEW PRODUCT -->
	</div>
	<!-- //Main wrapper -->

	<!-- JS Files -->
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/plugins.js"/>"></script>
	<script src="<c:url value="/resources/js/active.js"/>"></script>
	
</body>
</html>