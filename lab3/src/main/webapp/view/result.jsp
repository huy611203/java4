<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>1. Hình: ${img.name}</h2>
<img src="/lab3/files/${img.name}" height="100">
<h2>2. Tài liệu: ${doc.name}</h2>
<a href="/lab3/files/${doc.name}">Tải về</a>
</body>
</html>