<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<div class="row form-maggin">
			<div class="col-md-12 col-xs-12">
			<c:set value="${categories}" var="parents" scope="request"/>
			<c:set value="${category.parent.id}" var="selectedId"/>
				<form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/category" method="POST" modelAttribute="category">
					<form:hidden path="id"/>
					<form:hidden path="level"/>
					<div class="form-group">
    					<label for="parent" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-4">
      						<form:select class="form-control" path="parent" id="parent">
      							<option value="0">Буде батьківська</option>
      							<jsp:include page="optionCategory.jsp"/>
      						</form:select>
    					</div>
  					</div>
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-4"><form:errors path="name"/></label>
					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-4">
      						<form:input class="form-control" path="name" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-4">
      						<button type="submit" class="btn btn-primary">Create</button>
      						<a href="${pageContext.request.contextPath}/admin/category/cancel" class="btn btn-primary">Cancel</a>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4"><h3>Category name</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Update</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
		</div>
		<jsp:include page="divCategory.jsp"/>
	</div>
</div>