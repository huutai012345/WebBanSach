<%@page pageEncoding="utf-8"%>
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
	<!-- Main wrapper -->
	<div class="wrapper" id="wrapper">
		<!-- Header -->
		<jsp:include page="./header.jsp" />
		<!-- //Header -->
        <!-- Start Slider area -->
        <div class="slider-area brown__nav slider--15 slide__activation slide__arrow01 owl-carousel owl-theme">
        	<!-- Start Single Slide -->
	        <div class="slide animation__style10 bg-image--1">
	            <div class="container">
	            	<div class="row">
	            		<div class="col-lg-12">
	            			<div class="slider__content">
		            			<div class="contentbox">
		            				<h2>Buy <span>your </span></h2>
		            				<h2>favourite <span>Book </span></h2>
		            				<h2>from <span>Here </span></h2>
				                   	<a class="shopbtn" href="shop.htm">shop now</a>
		            			</div>
	            			</div>
	            		</div>
	            	</div>
	            </div>
            </div>
            <!-- End Single Slide -->
        </div>
        <!-- End Slider area -->
		<!-- Start BEst Seller Area -->
		<section class="wn__product__area brown--color pt--80  pb--30">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="section__title text-center">
							<h2 class="title__be--2">New <span class="color--theme">Products</span></h2>
						</div>
					</div>
				</div>
				<!-- Start Single Tab Content -->
				<div class="furniture--4 border--round arrows_style owl-carousel owl-theme row mt--50">
					<c:forEach var="data" items="${newBooks}">
					<!-- Start Single Product -->
					<div class="product product__style--3">
						<div class="col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="product__thumb">
								<a class="first__img" href="single-product/${data.id}.htm">
									<img src="<c:url value="${data.img}"/>" alt="product image">
								</a>
							</div>
							<div class="product__content content--center">
								<h4><a href="single-product/${data.id}.htm">${data.name}</a></h4>
								<ul class="prize d-flex">
									<li><fmt:formatNumber currencyCode="vi_VN" value="${data.price}" /> VND</li>
								</ul>	
							</div>
						</div>
					</div>
					</c:forEach>
				</div>
				<!-- End Single Tab Content -->
			</div>
		</section>
		<!-- Start BEst Seller Area -->
		<!-- Start NEwsletter Area -->
		<section class="wn__newsletter__area bg-image--2">
			<div class="container">
				<div class="row">
					<div class="col-lg-7 offset-lg-5 col-md-12 col-12 ptb--150">
						<div class="section__title text-center">
							<h2>Stay With Us</h2>
						</div>
						<div class="newsletter__block text-center">
							<p>Subscribe to our newsletters now and stay up-to-date with new collections, the latest lookbooks and exclusive offers.</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End NEwsletter Area -->
		<section class="best-seel-area pt--80 pb--60">
        	<div class="container">
          		<div class="row">
            		<div class="col-lg-12">
              			<div class="section__title text-center pb--50">
                			<h2 class="title__be--2">
                  				Best <span class="color--theme">Seller </span>
                			</h2>
              			</div>
            		</div>
          		</div>
        	</div>
        	<div class="slider center">
          		<!-- Single product start -->
          		<c:forEach var="data" items="${sellers}">
          		<div class="product product__style--3">
            		<div class="product__thumb">
              			<a class="first__img" href="single-product/${data.id}.htm">
              				<img src="<c:url value="${data.img}" />" alt="product image"/>
              			</a>
            		</div>
          		</div>
          		</c:forEach>
          		<!-- Single product end -->
        	</div>
        </section>
		<jsp:include page="./footer.jsp" />
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