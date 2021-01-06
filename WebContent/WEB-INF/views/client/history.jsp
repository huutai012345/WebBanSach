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
        <!-- cart-main-area start -->
        <div class="cart-main-area section-padding--lg bg--white">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 ol-lg-12">
                        <form action="#">               
                            <div class="table-content wnro__table table-responsive">
                                <table>
                                    <thead>
                                        <tr class="title-top">
                                            <th class="product-thumbnail">Image</th>
                                            <th class="product-name">Product</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-subtotal">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="data" items="${datas}">
                                        <tr>
                                            <td class="product-thumbnail">
                                            	<a href="single-product/${data.book.id}.htm">
                                            		<img src="<c:url value="${data.book.img}" />" alt="product img">
                                            	</a>
                                            </td>
                                            <td class="product-name"><a href="single-product/${data.book.id}.htm">${data.book.name}</a></td>
                                            <td class="product-price"><span class="amount finputAmount"><fmt:formatNumber currencyCode="vi_VN" value="${data.book.price}" /> VND</span></td>
                                            <td class="product-quantity"><span class="amount finputAmount">${data.amount}</span></td>
                                            <td class="product-subtotal"><fmt:formatNumber currencyCode="vi_VN" value="${data.amount*data.book.price}" /> VND</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </form> 
                    </div>
                </div>
            </div>  
        </div>
        <!-- cart-main-area end -->
		
		<!-- Footer Area -->
		
		<!-- END QUICKVIEW PRODUCT -->
	</div>
	<!-- //Main wrapper -->
	<jsp:include page="./footer.jsp" />
	<!-- JS Files -->
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/plugins.js"/>"></script>
	<script src="<c:url value="/resources/js/active.js"/>"></script>
	<script src="<c:url value="/resources/js/main-client1.js"/>"></script>
</body>
</html>