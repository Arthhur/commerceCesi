<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<a href="/Test/index.jsp"><button>Home</button></a>
		<form method="post" action="auth/addCategory">
	        <input type="text" name="nom" placeholder="name category"/><br/>
	        <button type="submit">Valider</button>
	    </form>
	</body>
</html>