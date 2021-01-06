<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-dark bg-dark justify-content-end">
		<div class="btn-group pull-right">
			<button type="button" class="btn btn-danger dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${name}</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="admin/logout.htm">Logout</a>
			</div>
		</div>
</nav>