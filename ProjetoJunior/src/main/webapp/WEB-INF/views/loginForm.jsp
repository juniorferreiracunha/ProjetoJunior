<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container body-content">
		<h1>Login</h1>
		<hr align="center" width="100%" size="1" color=red>
		<div class="row">
			<c:url var="post_url" value="/login" />
			<form:form method="post" action="${post_url}" role="form">
				<div class="validation-summary-errors text-danger">${errorMessage}</div>
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
				<div class="form-group">
					<input id="username" name="username" class="form-control"
						required="required" placeholder="e-mail" type="text" value="" />
				</div>
				<div class="form-group">
					<input id="password" name="password" placeholder="password"
						type="password" class="form-control" required="required" value="" />
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Login">

				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form>
		</div>
	</div>
	<hr align="center" width="100%" size="1" color=red>
	<footer>
	<p class="copyright text-muted small">Copyright &copy; ESTACIO.BR
		2017. All Rights Reserved</p>
	</footer>
	</div>

</body>
</html>