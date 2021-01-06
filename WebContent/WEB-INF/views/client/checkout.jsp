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
        <!-- Start Checkout Area -->
        <section class="wn__checkout__area section-padding--lg bg__white">
        	<div class="container">
        		<div class=row>
        			<div class="col-12">
        				<div class="checkout_info">
        					<span>Have a coupon? </span>
        					<a class="showcoupon" href="#">Click here to enter your code</a>
        				</div>
        				<div class="checkout_coupon">
        					<form action="#">
        						<div class="form__coupon">
        							<input type="text" placeholder="Coupon code">
        							<button>Apply coupon</button>
        						</div>
        					</form>
        				</div>
        			</div>
        		</div>
        		<div class="row">
        			<div class="col-lg-6 col-12">
        				<div id="accordion" class="checkout_accordion" role="tablist">
						    <div class="payment">
						        <div class="che__header" role="tab" id="headingOne">
						          	<a class="checkout__title" data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
						                <span>Direct Bank Transfer</span>
						          	</a>
						        </div>
						        <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
					            	<div class="payment-body">Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</div>
						        </div>
						    </div>
						    <div class="payment">
						        <div class="che__header" role="tab" id="headingThree">
						          	<a class="collapsed checkout__title" data-toggle="collapse" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
							            <span>Cash on Delivery</span>
						          	</a>
						        </div>
						        <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree" data-parent="#accordion">
					          		<div class="payment-body">Pay with cash upon delivery.</div>
						        </div>
						    </div>
						    <div class="payment">
						        <div class="che__header" role="tab" id="headingFour">
						          	<a class="collapsed checkout__title" data-toggle="collapse" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
							            <span>PayPal <img src="<c:url value="/resources/images/icons/payment.png"/>" alt="payment images"> </span>
						          	</a>
						        </div>
						        <div id="collapseFour" class="collapse" role="tabpanel" aria-labelledby="headingFour" data-parent="#accordion">
					          		<div class="payment-body">Pay with cash upon delivery.</div>
						        </div>
						    </div>
					    </div>
        				<div class="customer_details">
        					<div class="create__account">
        						<div class="account__field">
        							<form action="#">
        								<label>Account password <span>*</span></label>
        								<input type="text" placeholder="password">
        							</form>
        						</div>
        					</div>
        				</div>
        				<div class="customer_details mt--20">
        					<div class="differt__address">
	        					<input name="ship_to_different_address" value="1" type="checkbox">
	        					<span>Ship to a different address ?</span>
        					</div>
        					<div class="customar__field differt__form mt--40">
        						<div class="margin_between">
	        						<div class="input_box space_between">
	        							<label>First name <span>*</span></label>
	        							<input type="text">
	        						</div>
	        						<div class="input_box space_between">
	        							<label>last name <span>*</span></label>
	        							<input type="text">
	        						</div>
        						</div>
        						<div class="input_box">
        							<label>Address <span>*</span></label>
        							<input type="text" placeholder="">
        						</div>
								<div class="margin_between">
									<div class="input_box space_between">
										<label>Phone <span>*</span></label>
										<input type="text">
									</div>
									<div class="input_box space_between">
										<label>Email address <span>*</span></label>
										<input type="email">
									</div>
								</div>
        					</div>
        					
        				</div>
        			</div>
        			<div class="col-lg-6 col-12 md-mt-40 sm-mt-40">
        				<div class="wn__order__box">
        					<h3 class="onder__title">Your order</h3>
        					<ul class="order__total">
        						<li>Product</li>
        						<li>Total</li>
        					</ul>
        					<ul class="order_product">
        						<c:forEach var="data" items="${datas}">
        						<li>${data.book.name} × ${data.amount}<span><fmt:formatNumber currencyCode="vi_VN" value="${data.book.price * data.amount}" /> VND</span></li>
        						</c:forEach>
        					</ul>
        					<ul class="shipping__method">
        						<li>Cart Subtotal <span><fmt:formatNumber currencyCode="vi_VN" value="${totalOrder}" /> VND</span></li>
        						<li>Shipping 
        							<ul>
        								<li>
        									<label>	
        										<fmt:formatNumber currencyCode="vi_VN" value="30000" /> VND
        									</label>
        								</li>
        								
        							</ul>
        						</li>
        					</ul>
        					<ul class="total__amount">
        						<li>Order Total <span> 
        							<fmt:formatNumber currencyCode="vi_VN" value="${total}" /> VND</span>
        						</li>
        					</ul>
        				</div>
        				<h4 class="mb-3">Payment</h4>
        				<div class="d-block my-3">
          					<div class="custom-control custom-radio">
            					<input
              						id="credit"
              						name="paymentMethod"
              						type="radio"
              						class="custom-control-input"
              						checked
              						required
            					/>
            					<label class="custom-control-label" for="credit">Direct	Bank Transfer	</label>
          					</div>
          					<div class="custom-control custom-radio">
            					<input
              						id="debit"
             						name="paymentMethod"
              						type="radio"
              						class="custom-control-input"
              						required
            					/>
            					<label class="custom-control-label" for="debit">Cash on Delivery</label>
          					</div>
          					<div class="custom-control custom-radio">
            					<input
              						id="paypal"
              						name="paymentMethod"
              						type="radio"
              						class="custom-control-input"
              						required
            					/>
            					<label class="custom-control-label" for="paypal">PayPal</label>
          					</div>
        				</div>
        				<a class="btn btn-primary btn-lg btn-block" href="checkedout.htm">
          						Continue to checkout
        				</a>
        			</div>
        		</div>
        	</div>
        </section>
		
		<!-- Footer Area -->
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