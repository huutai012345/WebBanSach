<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside class="wedget__categories poroduct--cat">
	<h3 class="wedget__title">Product Categories</h3>
    <ul>
       <li><a href="shop.htm?page=1">All<span>${sumBook}</span></a></li>
       <c:forEach var="data" items="${cates1}">
        <li><a href="shop/${data.getKey().getId()}.htm?page=1">${data.getKey().getName()} <span>${data.getValue()}</span></a></li>
       </c:forEach>
    </ul>
</aside>