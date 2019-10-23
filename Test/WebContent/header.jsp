<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="css/header.css">
		
	</head>
	<body>
			<c:choose>
			    <c:when test="${user != null}">
				    <div class="header-container">
				       <a href="listProduct">Products List</a>
						<a href="displayCategories">Add Product</a>
						<a href="auth/searchProduct.jsp">Search Product</a>
						<a href="addCategory.jsp">Add Category</a>
						<a href="logOut">Déconnexion</a>
					</div>
			    </c:when>    
			    <c:otherwise>
				    <div class="header-container">
				        <a href="listProduct">Products List</a>
						<a href="displayCategories">Add Product</a>
						<a href="auth/searchProduct.jsp">Search Product</a>
						<a href="addCategory.jsp">Add Category</a>
					</div>
			    </c:otherwise>
			</c:choose>
	</body>
</html>