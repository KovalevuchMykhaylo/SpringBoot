<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<div class="col-sm-12 col-xs-12">
		<div class="col-sm-3 col-xs-3"><h2>Item view page <a href="${pageContext.request.contextPath}/admin/itemForm" class="btn btn-primary">Add</a></h2></div>
		<div class="col-sm-3 col-xs-3"><custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" /></div>
		<div class="col-sm-3 col-xs-3">
			<div class="row" style="margin-bottom: 20px; margin-top: 20px">
				<div class="col-md-6 col-xs-6 text-center">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<custom:sort innerHtml="Name asc" paramValue="name" />
							<custom:sort innerHtml="Name desc" paramValue="name,desc" />
						</ul>
					</div>
				</div>
				<div class="col-md-6 col-xs-6 text-center">
					<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-12 col-xs-12">
		<div class="row">
			<div class="col-md-2"><b>Date</b></div>
			<div class="col-md-2"><b>Title</b></div>
			<div class="col-md-4"><b>Description</b></div>
			<div class="col-md-2"><b>Price</b></div>
			<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
				<div class="col-md-1"><b>Edit</b></div>
				<div class="col-md-1"><b>Delete</b></div>
			</sec:authorize>

		</div>
		<c:forEach items="${page.content}" var="item">
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
						<a href="${pageContext.request.contextPath}/admin/itemForm/delete/${item.id}" class="btn btn-danger">Delete</a>
					</div>
				</sec:authorize>
			</div>
		</c:forEach>
	</div>
</div>