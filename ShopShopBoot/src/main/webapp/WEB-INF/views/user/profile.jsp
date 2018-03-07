<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="row">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-6">
				<img src="data:image/jpg;base64, ${imgFromDb}" class="img-rounded" width="300"/>
			</div>
			<div class="col-md-6">
				<p>Login ${user.login}</p>
				<p>Email ${user.email}</p>
				<p>Name ${user.firstName}</p>
				<p>Second Name ${user.lastName}</p>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-6">
				<p>New avatar</p>
				<form:form action="/user/profile/newAvatar" class="form-inline"
					method="POST" enctype="multipart/form-data">
					<div class="form-group">
						<input type="file" name="fileUpload">
					</div>
					<input type="submit" value="Upload file">
				</form:form>
			</div>
			<div class="col-md-6"></div>
		</div>
	</div>
</div>