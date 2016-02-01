<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>

	<h2>Categories:</h2>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>description</td>
			<td>categories</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>
					<ol>
						<c:if test="${product.categories.size() > 0}">
							<c:forEach var="category" items="${product.categories}">
								<li>${category.name}</li>
							</c:forEach>
						</c:if>
						<li><b>add</b></li>
					</ol>
				</td>

				<td style="color: orange"><a
					href='<c:url value="/admin/product/edit/${product.id}"/>'><b>edit</b></a></td>
				<td style="color: RED"><a
					href='<c:url value="/admin/product/delete/${product.id}"/>'><b>delete</b></a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td style="color: green"><a href="/admin/category/add"><b>Add</b></a></td>
		</tr>
	</table>
</body>
</html>