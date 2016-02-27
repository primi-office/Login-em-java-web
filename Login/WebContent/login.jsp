<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Controle de estoque</h1>

<h3>Login</h3>
<form  action="autentica" method="post">
<c:if test="${not empty login_erro}">
<p>${login_erro}</p>
</c:if>
  Usuário:<input type="text" name="usuario"><br/>
  Senha:<input type="password" name="senha"><br/>
        <input type="submit" value="Entrar">
</form>
</body>
<% session.removeAttribute("login_erro"); %>
</html>