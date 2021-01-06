<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>About | Bookshop</title>
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
		<!-- End Search Popup -->
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
        <!-- Start About Area -->
        <div class="page-about about_area bg--white section-padding--lg">
        	<div class="container">
				<div class="row">
        			<div class="col-lg-12">
        				<div class="section__title--3 text-center pb--30">
        					<h2>Our Process Skill Of High</h2>
        				</div>
        			</div>
        		</div>
        		<div class="row align-items-center">
					<div class="col-lg-6 col-sm-12 col-12">
        				<div class="content text-left text_style--2">
    					    <h2>we have skills to show</h2>
    					    <div class="skill-container">
    					        <!-- Start single skill -->
    					        <div class="single-skill">
    					            <p>Customer Favorites</p>
    					            <div class="progress">
    					                <div class="progress-bar wow fadeInLeft" data-wow-duration="0.8s" data-wow-delay=".5s" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width:90%"><span class="pen-lable"></span>
    					                </div>
    					            </div>
    					        </div>
    					        <!-- End single skill -->
    					        <!-- Start single skill -->
    					        <div class="single-skill">
    					            <p>Popular Authors</p>
    					            <div class="progress">
    					                <div class="progress-bar wow fadeInLeft" data-wow-duration="0.8s" data-wow-delay=".5s" role="progressbar" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" style="width:95%"><span class="pen-lable"></span>
    					                </div>
    					            </div>
    					        </div>
    					        <!-- End single skill -->
    					        <!-- Start single skill -->
    					        <div class="single-skill">
    					            <p>Bestselling Series</p>
    					            <div class="progress">
    					                <div class="progress-bar wow fadeInLeft" data-wow-duration="0.8s" data-wow-delay=".5s" role="progressbar" aria-valuenow="93" aria-valuemin="0" aria-valuemax="100" style="width:93%"><span class="pen-lable"></span>
    					                </div>
    					            </div>
    					        </div>
    					        <!-- End single skill -->
    					        <!-- Start single skill -->
    					        <div class="single-skill">
    					            <p>Bargain Books</p>
    					            <div class="progress">
    					                <div class="progress-bar wow fadeInLeft" data-wow-duration="0.8s" data-wow-delay=".5s" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width:90%"><span class="pen-lable"></span>
    					                </div>
    					            </div>
    					        </div>
    					        <!-- End single skill -->
    					    </div>
        				</div>
        			</div>
        			<div class="col-lg-6 col-sm-12 col-12">
        				<div class="content">
        					<h3>Buy Book</h3>
        					<h2>Different Knowledge</h2>
        					<p class="mt--20 mb--20">We believe that bookstores are essential to a healthy culture. They’re where authors can connect with readers, where we discover new writers, where children get hooked on the thrill of reading that can last a lifetime. They’re also anchors for our downtowns and communities.</p>
        					<strong>Address</strong>
        					<p>PTIT HCM</p>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
        <!-- End About Area -->
		<!-- Footer Area -->
		<jsp:include page="./footer.jsp" />
		<!-- //Footer Area -->

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