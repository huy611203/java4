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
  <form action="/lab6_demo/findvideotitle"method="post">
   <input name="keywrod"/><button>Search</button>
   </form>

   <table border="1">
        <thead>
        <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Views</th>
        <th>Active</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var = "item" items="${videos }">     
         <tr>
        <td>${item.id }</td>
        <td>${item.title }</td>
        <td>${item.views }</td>
        <td>${item.active }</td>
        </tr>
        </c:forEach> 
        
        </tbody>
   </table>
</body>
</html>