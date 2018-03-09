<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<div class="row form-maggin">
	<div class="col-md-3 col-xs-3">
		<form:form class="form-inline" action="/admin/country" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search"/>
			<div class="form-group">
				<form:input path="search" class="form-control" placeholder="Search"/>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
			<a href  = "/admin/country/cancel" class="btn btn-primary" >Cancel</a>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-7">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/country" method="POST" modelAttribute="country">
					<div class="form-group">
						<label for="name" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="name"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label for="shortName" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="shortName"/></label>
					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Short Name</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="shortName"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create</button>
      						<a href  = "/admin/country/cancel" class="btn btn-primary" >Cancel</a>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-3"><h3>Name</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Short Name</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Update</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${page.content}" var="country">
				<div class="row">
					<div class="col-md-3 col-xs-3">${country.name}</div>
					<div class="col-md-3 col-xs-3">${country.shortName}</div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-success" href="/admin/country/update/${country.id}<custom:allParams/>">Update</a></div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-danger" href="/admin/country/delete/${country.id}<custom:allParams/>">Delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
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
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>