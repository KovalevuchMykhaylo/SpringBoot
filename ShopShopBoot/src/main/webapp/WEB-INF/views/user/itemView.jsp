<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<div class="row">
	<div class="col-sm-12 col-xs-12">
		<h2>Item view page</h2>
		<div class="row">
			<div class="col-md-2">Date</div>
			<div class="col-md-2">Title</div>
			<div class="col-md-4">Description</div>
			<div class="col-md-2">Price</div>
			<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
				<div class="col-md-1">Edit</div>
				<div class="col-md-1">Delete</div>
			</sec:authorize>

		</div>
		<c:forEach items="${items}" var="item">
			<div class="row" id="itemHover">
				<div class="col-md-2">
					<fmt:formatDate value="${item.createdAt}"
						pattern="yyyy-MM-dd HH:mm" />
				</div>
				<div class="col-md-2">${item.title}</div>
				<div class="col-md-4">${item.description}</div>
				<div class="col-md-2">${item.price}$</div>
				<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
					<div class="col-md-1">
						<a href="/admin/itemForm/update/${item.id}"
							class="btn btn-warning">Edit</a>
					</div>
					<div class="col-md-1">
						<a href="/admin/itemForm/delete/${item.id}" class="btn btn-danger">Delete</a>
					</div>
				</sec:authorize>
			</div>
		</c:forEach>
	</div>
</div>
<style>
#itemHover:hover {
	color: #ffb300;
	font-weight: bold;
}
</style>