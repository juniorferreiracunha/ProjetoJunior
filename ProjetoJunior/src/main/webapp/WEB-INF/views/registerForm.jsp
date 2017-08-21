<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Registar Usuário</h1>
<form:form method="post" action="/user/register" modelAttribute="user"
role="form">
<div>
<form:input path="name" class="form-control"
placeholder="Nome" required="required" />
</div>
<div>
<form:input path="email" class="form-control"
placeholder="E-mail" required="required" />
</div>
<div>
<form:password path="pwd" class="form-control"
placeholder="Senha" required="required" />
</div>
<div>
<input type="submit" value="Confirmar">
</div>
</form:form>

</body>
</html>