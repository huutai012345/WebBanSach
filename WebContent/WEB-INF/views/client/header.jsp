<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="wn__header" class="header__area header__absolute sticky__header">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 col-sm-6 col-6 col-lg-2">
						<div class="logo">
							<a href="index.htm">
								<img src="<c:url value="/resources/images/logo/logo.png"/>" alt="logo images">
							</a>
						</div>
					</div>
					<div class="col-lg-8 d-none d-lg-block">
						<nav class="mainmenu__nav">
							<ul class="meninmenu d-flex justify-content-start">
								<li class="drop with--one--item"><a href="index.htm">Home</a></li>
								<li class="drop"><a href="shop.htm?page=1">Shop</a>
								</li>
								<li class="drop"><a href="about.htm">About</a>
								</li>
							</ul>
						</nav>
					</div>
					<div class="col-md-6 col-sm-6 col-6 col-lg-2">
						<ul class="header__sidebar__right d-flex justify-content-end align-items-center">
							<li class="shopcart"><a href="cart.htm"><span class="product_qun">3</span></a>
							</li>
							<li class="setting__bar__icon"><a class="setting__active" href="#"></a>
								<div class="searchbar__content setting__block">
									<div class="content-inner">
										<div class="switcher-currency">
											<c:choose>
												<c:when test = "${name != null}">
        											<strong class="label switcher-label">
														<span>${name}</span>
													</strong>
													<div class="switcher-options">
														<div class="switcher-currency-trigger">
															<div class="setting__menu">
																<span><a href="cart.htm">My Cart</a></span>
																<span><a href="history.htm">History</a></span>
																<span><a href="my-account.htm">My Account</a></span>
																<c:if test = "${role == 'admin'}">
         														<span><a href="admin/index.htm">Admin Page</a></span>
      															</c:if>
																<span><a href="logout.htm">Logout</a></span>
															</div>
														</div>
													</div>	
      											</c:when>	
      											<c:otherwise>
            										<strong class="label switcher-label">
														<span>My Account</span>
													</strong>
													<div class="switcher-options">
														<div class="switcher-currency-trigger">
															<div class="setting__menu">
																<span><a href="login.htm">Login</a></span>
																<span><a href="register.htm">Create An Account</a></span>
															</div>
														</div>
													</div>	
         										</c:otherwise>
         									</c:choose>
											
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>		
		</header>