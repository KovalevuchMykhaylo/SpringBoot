<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h1>${user.role} ${user.firstName} ${user.lastName}</h1>
	<a href="${pageContext.request.contextPath}/admin/dashboard">SummerTimeSadness</a>
	<c:forEach items="${be}" var="ber">
		<div>
			${ber.title}
		</div>
	</c:forEach>