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
	<form action="${url}/sign-up" method="post">
		<input name="id" placeholder="username"><br>
		<input name="password" type="password" placeholder="password"><br>
		<input name="fullname" placeholder="fullname"><br>
		<input name="email" placeholder="email"><br>
		<input name="admin" type="hidden" value="false"><br>
		<input type="submit" value="đăng ký"/>
		<a href="${url}/sign-in">quay lại đăng nhập</a>
	</form>
	<p>${result}</p>
</body>
</html>