<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<c:if test="${param.fail}">
		<div class="col-sm-12 col-xs-12">
			<h2 id="blink">Fail to autorize</h2>
		</div>
	</c:if>
	<div class="col-sm-12 col-xs-12">
		<form:form class="form-horizontal form-maggin" action="${pageContext.request.contextPath}/login" method="POST">
			<div class="form-group">
				<label for="login" class="col-sm-4 control-label">Login</label>
				<div class="col-sm-4">
					<input class="form-control" name="login" id="login">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-4 control-label">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password"
						id="user">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<div class="checkbox">
						<label> <input name="rememberMe" type="checkbox">
							Remember me
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-primary">Sign in</button>
				</div>
			</div>
		</form:form>
	</div>
</div>