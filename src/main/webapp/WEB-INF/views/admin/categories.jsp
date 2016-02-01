<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories</title>
</head>
<body>

	<h2>Categories:</h2>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<c:forEach var="category" items="${productCategoryList}">
			<tr>
				<td>${category.id}</td>
				<td><a
					href='<c:url value="/admin/products?categoryId=${category.id}"/>'>${category.name}</a></td>
				<td style="color: orange"><a
					href='<c:url value="/admin/category/edit/${category.id}"/>'><b>edit</b></a></td>
				<td style="color: RED"><a
					href='<c:url value="/admin/category/delete/${category.id}"/>'><b>delete</b></a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td style="color: green"><a href="/admin/category/add" /><b>Add</b></a></td>
		</tr>
	</table>
</body>
</html>