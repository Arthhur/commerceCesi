<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<body>
		<a href="/Test/index.jsp"><button class="btn btn-success" style="margin : 10px">Home</button></a>
		<form method="post" action="addProduct" class="col-md-4">
	        <input class="form-control" type="text" name="nom" placeholder="nom"/><br/>
	        <input class="form-control" type="text" name="contenu" placeholder="contenu"/><br/>
	        <input class="form-control" type="text" name="prix" placeholder="prix"/><br/>
	        <select class="form-control" name='category'>
			    <c:forEach items="${categories}" var="category">
			            <option value="${category.id}">${category.nom}</option>
			    </c:forEach>
			</select><br />
	        <button class="btn btn-primary" type="submit">Valider</button>
	    </form>
	</body>
</html>