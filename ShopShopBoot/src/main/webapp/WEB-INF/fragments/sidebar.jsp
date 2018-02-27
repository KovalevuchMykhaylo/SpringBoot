<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="col-sm-2 sidenav">
	<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
		<p>
			<a href="/admin/itemForm">Create Item</a>
		</p>
		<p>
			<a href="/admin/category">Category</a>
		</p>
	</sec:authorize>
	<sec:authorize access="isAuthenticated() and hasAnyRole('ROLE_USER, ROLE_ADMIN')">
	<p>
		<a href="/user/itemView">Show Items</a>
	</p>
	</sec:authorize>
	<p>
		<a href="/student">Student</a>
	</p>
</div>