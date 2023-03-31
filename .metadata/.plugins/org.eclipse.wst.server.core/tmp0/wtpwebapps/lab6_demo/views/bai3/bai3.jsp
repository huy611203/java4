<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="/lab6_demo/finduser"method="post">
   <input name="keywrod"/><button>Search</button>
   </form>

   <table border="1">
        <thead>
        <tr>
        <th>User</th>
        <th>Fullname</th>
        <th>Email</th>
        <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var = "item" items="${users }">     
         <tr>
        <td>${item.id }</td>
        <td>${item.fullname }</td>
        <td>${item.email }</td>
        <td>${item.admin }</td>
        </tr>
        </c:forEach> 
        
        </tbody>
   </table>
</body>
</html>