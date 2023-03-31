<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<mark>${message}</mark>
<form action="/lab3/bai3" method="post">
Username: <input name="username"><br>
Password: <input name="password" type="password"><br>
<input name="remember" type="checkbox">Remember me?
<hr>
<button>Login</button>
</form>

</body>
</html>