<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/lab2/DangKy" method="post">
Tên Đăng Nhập: <input name="Ten"><br>
Mật Khẩu: <input name="matKhau"><br>
Giới tính
<input name="gioiTinh" type="radio" value="true">nam
<input name="gioiTinh" type="radio" value="false">nữ <br>
<input name="DaCoGiaDinh" type="checkbox">Đã có gia đình <br>
Quốc tịch <select name="country">
 <option value="VN">Việt Nam</option>
<option value="US">United States</option>
</select> <br>
Ghi chú: <textarea name="notes" rows="3" cols="30"></textarea>
<hr>
<button>Đăng ký</button>


</form>
</body>
</html>