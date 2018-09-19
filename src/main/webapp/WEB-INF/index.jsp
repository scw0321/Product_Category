
<%@ page language ="java" contentType="text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset = "UFT-8">
<title>Driver's License</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<h1>Products</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Category Count</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${product}" var="p">
        <tr>
            <td><c:out value="${p.name}"/></td>
            <td><c:out value="${p.description}"/></td>
             <td><c:out value="${p.price}"/></td>            
        </tr>
        </c:forEach>
    </tbody>
</table>

<h1>Categories</h1>
<table>
    <thead>
        <tr>
            <th>Category Name</th>
            <th>Product Count</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${category}" var="c">
        <tr>
            <td><c:out value="${c.name}"/></td>         
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>