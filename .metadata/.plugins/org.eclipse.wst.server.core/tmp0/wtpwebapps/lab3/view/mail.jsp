<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<div>
<form action="/lab3/bai4" method="post">
Send mail <br>
${message } <br>
<p>From:</p> <input name="form" value="bhuy94809@gmail.com">
<p>To:</p> <input name="to" value="bhuy94809@gmail.com" >
<p>Subject:</p> <input name="subject" >
<p>Body:</p> <input name="body" >
<hr>
<button>Send mail</button>
</form>
</div>
</body>
</html>