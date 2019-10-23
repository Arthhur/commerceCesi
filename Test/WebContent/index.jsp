<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/index.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div class="container">
			<c:if test="${user == null}">
				<form method="post" action="login">
			        <input name="user" placeholder="user"/><br/>
			        <button type="submit">Valider</button>
			    </form>
			</c:if>   		
		</div>		
	    <%@ include file="footer.jsp" %> 
	</body>
</html>