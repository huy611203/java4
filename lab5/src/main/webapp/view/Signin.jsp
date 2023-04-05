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
	<form action="${url}/sign-in" method="post">
		<input name="username" type="text" placeholder="username"><br>
 		<input name="password" type="password" placeholder="password"><br>
		<input type="submit" value="đăng nhập"><br>
		<a href="${url}/sign-up">đăng ký</a>
	</form>
	<p>${result}</p>
</body>
</html>