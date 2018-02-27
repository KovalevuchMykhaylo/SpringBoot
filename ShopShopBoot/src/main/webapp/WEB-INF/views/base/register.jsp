<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<div class="row">
	<div class="col-sm-12 col-xs-12">
		<form:form class="form-horizontal" action="/register" method="POST" modelAttribute="user">
  			<div class="form-group"><h2 class="col-sm-offset-5 col-sm-2">Registration</h2></div>
  			<div class="form-group">
                <label for="email" style="color:red;text-align:left;"><form:errors path="email"/></label>
            </div>
			<div class="form-group">
    			<label for="email" class="col-sm-4 control-label">Email</label>
    			<div class="col-sm-4">
      				<form:input class="form-control" path="email"/>
    			</div>
  			</div>
  			<div class="form-group">
                <label for="login" style="color:red;text-align:left;"><form:errors path="login"/></label>
            </div>
  			<div class="form-group">
    			<label for="login" class="col-sm-4 control-label">Login</label>
    			<div class="col-sm-4">
      				<form:input class="form-control" path="login"/>
    			</div>
  			</div>
  			<div class="form-group">
                <label for="password" style="color:red;text-align:left;"><form:errors path="password"/></label>
            </div>
			<div class="form-group">
    			<label for="password" class="col-sm-4 control-label">Password</label>
    			<div class="col-sm-4">
      				<form:input type="password" class="form-control" path="password"/>
    			</div>
  			</div>
  			<div class="form-group">
                <label for="passConfirm" style="color:red;text-align:left;"><form:errors path="passConfirm"/></label>
            </div>
  			<div class="form-group">
    			<label for="passConfirm" class="col-sm-4 control-label">Confirm password</label>
    			<div class="col-sm-4">
      				<form:input type="password" class="form-control" path="passConfirm"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-4 col-sm-4">
      				<button type="submit" class="btn btn-primary">Register</button>
      				<a href  = "/register/cancel" class="btn btn-primary" >Cancel</a>
    			</div>
  			</div>
		</form:form>
	</div>
</div>
<script>
    $('label').each(function () {
        if (!$(this).html()) $(this).parent('div').hide();
    });
</script>