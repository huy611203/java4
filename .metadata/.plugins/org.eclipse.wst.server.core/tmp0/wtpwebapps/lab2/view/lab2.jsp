<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/lab2/lab2.java" method="post">
<input name="a" placeholder="Cạnh a?"><br>
<input name="b" placeholder="Cạnh b?"><br>
<input name="c" placeholder="Cạnh c?"><br>
<button formaction="/lab2/dientich">Tính diện tích</button>
<button formaction="/lab2/chuvi">Tính chu vi</button>
</form>
<h3>${message }</h3>
</body>
</html>