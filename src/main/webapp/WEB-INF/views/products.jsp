<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>

<h2>Categories:</h2>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>description</td>
        <td></td>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td style="color: orange">
                <a href='<c:url value="/product/${product.id}/addToCart"/>'><b>Add to cart</b></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>