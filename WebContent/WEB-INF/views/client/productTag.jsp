<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside class="wedget__categories poroduct--tag">
	<h3 class="wedget__title">Product Tags</h3>
        <ul>
        	<c:forEach var="data" items="${cates}">
        	<li><a href="shop/${data.id}.htm?page=1"><c:out value="${data.name}" /></a></li>
        	</c:forEach>
        </ul>
</aside>