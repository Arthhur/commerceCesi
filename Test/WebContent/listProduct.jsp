<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%>
<%@page import="fr.cesi.commerce.doa.ProductDao"%> 
<%@page import="fr.cesi.commerce.model.Product"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List Product</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<body>
		<a href="/Test/index.jsp"><button class="btn btn-success" style="margin : 10px">Home</button></a>
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Contenu</th>
				<th>Category</th>
				<th>Prix</th>
				<th></th>
			</tr>
			<c:forEach items="${Products}" var="produit">
				<c:set var="path" value="auth/removeProduct?id=${produit.id}" scope="page" />
	    		<tr>
	    			<td><c:out value="${produit.id}" /></td> 
	    			<td><c:out value="${produit.nom}" /></td>
	    			<td><c:out value="${produit.contenu}" /></td>
	    			<td><c:out value="${produit.category.nom}" /></td>
	    			<td><c:out value="${produit.prix}" /></td>
	    			<td><a href=${path}><button class="btn btn-danger">Supprimer</button></a></td>
	    		</tr>
			</c:forEach>
		</table>
	</body>
</html>