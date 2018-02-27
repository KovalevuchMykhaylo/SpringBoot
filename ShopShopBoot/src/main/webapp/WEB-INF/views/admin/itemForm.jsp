<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-sm-12 col-xs-12">
		<form:form class="form-horizontal" action="/admin/itemForm" method="POST" modelAttribute="item">
		<div class="form-group"><h2 class="col-sm-offset-3 col-sm-5">Admin Item Form</h2></div>
			<div class="form-group">
    			<label for="title" class="col-sm-4 control-label">Title</label>
    			<div class="col-sm-4">
      				<form:input class="form-control" path="title" id="title" placeholder="Title"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="description" class="col-sm-4 control-label">Description</label>
    			<div class="col-sm-4">
      				<form:textarea rows="3" class="form-control" path="description" id="description" maxlength="1000" placeholder="Description"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="price" class="col-sm-4 control-label">Price</label>
    			<div class="col-sm-4">
<%--       				<form:input class="form-control" path="price" type="price" id="price" min="0"  step="0.1" placeholder="Price"/> --%>
      				<form:input class="form-control" path="price" type="number" id="price" min="0"  step="0.01" placeholder="Price" value="0"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-4 col-sm-4">
      				<button type="submit" class="btn btn-primary">Create</button>
    			</div>
  			</div>
		</form:form>
	</div>
</div>