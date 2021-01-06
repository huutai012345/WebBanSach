<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<aside class="wedget__categories poroduct--tag">
	<h3 class="wedget__title">Search</h3>
	<ul>
		<div style="float: right; margin-bottom: 20px">
			<form:form action="${url}" modelAttribute="userForm" method="GET">
					<input type="text" placeholder="Search.." name="search"
					value="${search}"
					style="padding: 6px; margin-top: 8px; font-size: 15px;">
				<button type="submit"
					style="float: right; padding: 6px 10px; margin-top: 8px; margin-right: 16px; background: #ddd; font-size: 17px; border: none; cursor: pointer;">
					<i class="fa fa-search"></i>
				</button>
			</form:form>
		</div>
	</ul>
</aside>