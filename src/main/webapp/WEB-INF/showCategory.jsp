<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Category</title>
</head>
<body>
<h1><c:out value="${category.name}"/></h1>

   <c:forEach items="${category}" var="c">
   		<c:out value="${c.name}"/>
        
<h1>Add Product</h1>
<form:form action="/products/create" method="post" modelAttribute="product">
    <p>
        <form:select path="name">   
        <c:forEach items="${product}" var="p">        
        	<form:option value="${p.id}"><c:out value="${p.name}"/></form:option>        
        </c:forEach>  
        </form:select>        
 	
    <input type="submit" value="Add"/>
</form:form>
</body>
</html>