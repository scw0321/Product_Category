<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
</head>
<body>
<h1><c:out value="${product.name}"/></h1>

   <c:forEach items="${product}" var="p">
   		<c:out value="${p.name}"/>
        
<h1>Add Category</h1>
<form:form action="/categories/create" method="post" modelAttribute="category">
    <p>
        <form:select path="name">   
        <c:forEach items="${category}" var="c">        
        	<form:option value="${c.id}"><c:out value="${c.name}"/></form:option>        
        </c:forEach>  
        </form:select>        
 	
    <input type="submit" value="Add"/>
</form:form>    
</body>
</html>