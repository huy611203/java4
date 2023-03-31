<%--
  Created by IntelliJ IDEA.
  User: quannv
  Date: 2023-03-24
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Video</title>
</head>
<body>
<h1>${listAllVideo[0].title}</h1>
<h1>${message}</h1>
<c:url var="url" value="/video"></c:url>
<div>
    <form action="${url}/index" method="post">
        <input value="${videoForm.id}" name="id" placeholder="Mã video"> <br>
        <input value="${videoForm.title}" name="title" placeholder="Title video">  <br>
        <input value="${videoForm.url}" name="url" placeholder="Url">  <br>
        <input value="${videoForm.views}" name="views" placeholder="View number">  <br>
        <input value="${videoForm.shares}" name="shares" placeholder="Shares number"> <br>
        <br>
        <button formaction="${url}/create">Create</button>
        <button formaction="${url}/edit">Edit</button>
        <button formaction="${url}/delete">Delete</button>
        <a href="${url}/index" >Reset</a>
    </form>
</div>
<table border="1">
    <thead>
        <th>ID</th>
        <th>Title</th>
        <th>Url</th>
        <th>View</th>
        <th>Share</th>
        <th>Edit</th>
    </thead>

    <tbody>
    <c:forEach var="video" items="${listAllVideo}">
        <tr>
        <td>${video.id}</td>
        <td>${video.title}</td>
        <td>${video.url}</td>
        <td>${video.views}</td>
        <td>${video.shares}</td>
            <td> <a href="${url}/edit/${video.id}">Edit</a> </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
