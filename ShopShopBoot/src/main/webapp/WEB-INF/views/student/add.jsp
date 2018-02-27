<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="form-group">
	<h2 class="col-sm-offset-5 col-sm-2">Student</h2>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<form:form action="${pageContext.request.contextPath}/student/add"
			method="POST" modelAttribute="studentModel">

			<div class="form-group">
				<label for="name" class="col-md-4 control-label">Full name:</label>
				<div class="col-md-8">
					<form:input class="form-control" path="fullName" />
				</div>
			</div>

			<div class="form-group">
				<label for="country" class="col-md-4 control-label">Student
					country:</label>
				<div class="col-md-8">
					<form:select class="form-control" path="country" items="${country}" />
				</div>
			</div>

			<div class="form-group">
				<label for="age" class="col-md-4 control-label">Student age:</label>
				<div class="col-md-8">
					<form:select class="form-control" path="age" items="${age}" />
				</div>
			</div>

			<div class="form-group">
				<label for="gender" class="col-md-4 control-label">Student
					gender:</label>
				<div class="col-md-8">
					<form:select path="gender" class="form-control">
						<form:options items="${studentGenders}" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<label for="email" class="col-md-4 control-label">Student
					email:</label>
				<div class="col-md-8">
					<form:input class="form-control" path="email" />
				</div>
			</div>

			<div class="form-group">
				<label for="degree" class="col-md-4 control-label">Student
					degree:</label>
				<div class="col-md-8">
					<form:select path="degree" class="form-control">
						<form:options items="${studentDegrees}" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<label for="socialNetworks" class="col-md-4 control-label">Student
					socialNetworks:</label>
				<div class="col-md-8" class="form-inline">
					<form:checkbox path="socialNetworks" value="VK" label="VK" />
					<form:checkbox path="socialNetworks" value="OK" label="OK" />
					<form:checkbox path="socialNetworks" value="FB" label="FB" />
					<form:checkbox path="socialNetworks" value="TW" label="TW" />
					<form:checkbox path="socialNetworks" value="LI" label="LI" />
				</div>
			</div>

			<div class="form-group">
				<label for="email" class="col-md-4 control-label">Student
					favouriteLanguage:</label>
				<div class="col-md-8" class="form-inline">
					<form:radiobutton path="favouriteLanguage" value="Java"
						label="Java" />
					<form:radiobutton path="favouriteLanguage" value="C#" label="C#" />
					<form:radiobutton path="favouriteLanguage" value="PHP" label="PHP" />
				</div>
			</div>

			<div class="form-group">
				<label for="operationSystem" class="col-md-4 control-label">Student
					operationSystem:</label>
				<div class="col-md-8" class="form-inline">
					<form:checkbox path="operationSystem" value="MS Windows"
						label="MS Windows" />
					<form:checkbox path="operationSystem" value="Linux" label="Linux" />
					<form:checkbox path="operationSystem" value="MAC OS" label="MAC OS" />
					<form:checkbox path="operationSystem" value="Android"
						label="Android" />
					<form:checkbox path="operationSystem" value="IOS" label="IOS" />
				</div>
			</div>

			<div class="form-group">
				<label for="workExp" class="col-md-4 control-label">Student
					workExp:</label>
				<div class="col-md-8" class="form-inline">
					<form:radiobutton path="workExp" value="0-6mnth" label="0-6mnth" />
					<form:radiobutton path="workExp" value="6mnth-1year"
						label="6mnth-1year" />
					<form:radiobutton path="workExp" value="1-3years" label="1-3years" />
					<form:radiobutton path="workExp" value="4-5years" label="4-5years" />
				</div>
			</div>


			<div class="form-group">
				<label for="workQualification" class="col-md-4 control-label">Student
					qualification:</label>
				<div class="col-md-8">
					<form:select class="form-control" path="workQualification"
						items="${qualification}" />
				</div>
			</div>

			<div class="form-group">
				<label for="skils" class="col-md-4 control-label">Student
					skils:</label>
				<div class="col-md-8" class="form-inline">
					<form:checkbox path="skills" value="HTML" label="HTML" />
					<form:checkbox path="skills" value="CSS" label="CSS" />
					<form:checkbox path="skills" value="MySQL" label="MySQL" />
					<form:checkbox path="skills" value="Hibernate" label="Hibernate" />
					<form:checkbox path="skills" value="Spring" label="Spring" />
					<form:checkbox path="skills" value="SpringSecurity"
						label="SpringSecurity" />
					<form:checkbox path="skills" value="JDBC" label="JDBC" />
					<form:checkbox path="skills" value="Casandra DB"
						label="Casandra DB" />
					<form:checkbox path="skills" value="JS" label="JS" />
					<form:checkbox path="skills" value="AngularJS" label="AngularJs" />
				</div>
			</div>

			<div class="form-group">
				<label for="howUFoundUs" class="col-md-4 control-label">Student
					howUFoundUs: </label>
				<div class="col-md-8">
					<form:input class="form-control" path="howUFoundUs" />
				</div>
			</div>

			<button class="btn btn-warning" type="submit">SEND</button>

		</form:form>
	</div>
</div>
