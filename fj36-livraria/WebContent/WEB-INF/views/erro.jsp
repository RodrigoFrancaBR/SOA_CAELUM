<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>


<html> 
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	</head>
				
	<body class="index">

		<div class="jumbotron">
		
			<p>
				Um erro aconteceu, por favor verifique o console no Eclipse.
				<img alt="gatinho" src="<c:url value="/resources/imagens/gatinho.jpeg" />" />
				Desculpe ....
			</p>
			
			<div>
				<a class="btn btn-default" href="<c:url value="/loja/index" />"> <span class="glyphicon glyphicon-book"></span> Ou volte a loja já ...</a>
			</div>		
		
		</div>
	</body>
</html>