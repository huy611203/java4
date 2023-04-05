<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="url" value="/account"></c:url>
	<form action="${url}/edit-profile" method="post">
		<input name="id" value="${user.id}" placeholder="username" type="hidden"/><br>
		<input name="password" value="${user.password}" placeholder="password" type="password"/><br>
		<input name="fullname" value="${user.fullname}" placeholder="fullname"/><br>
		<input name="email" value="${user.email}" placeholder="email"/><br>
		<input name="admin" type="hidden" value="${user.admin}"/><br>
		<input type="submit" value="update"/>
	</form>
	<p>${result}</p>
</body>
</html>