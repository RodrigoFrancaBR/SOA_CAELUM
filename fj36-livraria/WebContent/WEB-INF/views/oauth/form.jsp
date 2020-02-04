<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<c:url value="/resources/css/bootstrap.css" var="css" />
<c:url value="/resources/js/jquery.js" var="jquery" />
<c:url value="/resources/js/bootstrap.min.js" var="bootstrapjs" />

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${css}">
</head>

<body class="index">

	<c:import url="/WEB-INF/views/menu-navegacao.jsp" />

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-md-9 col-xs-12">
				<form action="<c:url value='/oauth/password/token'/>" method="post">
					<label for="username">Login do Payfast</label>
					<input name="username" id="username" placeholder="Username Payfast" class="form-control"/>
					
					<label for="password">Login</label>
					<input name="password" id="password" placeholder="Password Payfast" class="form-control" type="password"/>
					
					<input type="submit" class="btn btn-success" value="Logar no payfast"/>
				</form>
			</div>

			<div class="col-md-3 col-xs-12">
				<c:import url="/WEB-INF/views/menu-treinamentos.jsp" />
			</div>

		</div>

		<c:import url="/WEB-INF/views/footer.jsp" />

	</div>
	
	<script src="${jquery}"></script>
	
	<script src="${bootstrapjs}"></script>
	
</body>
</html>