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


   <table border="1">
        <thead>
        <tr>
        <th>ID</th>
        <th>Favorite Count</th>
        <th>Newest Date</th>
        <th>Oldest Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var = "item" items="${videos }">     
         <tr>
        <td>${item.group }</td>
        <td>${item.likes }</td>
        <td>${item.newest }</td>
        <td>${item.oldest }</td>
        </tr>
        </c:forEach> 
        
        </tbody>
   </table>
</body>
</html>