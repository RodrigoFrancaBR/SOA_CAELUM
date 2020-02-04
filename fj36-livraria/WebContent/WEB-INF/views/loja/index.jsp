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

				<div class="jumbotron">
					<h1>Livraria 36</h1>
					<p>Os melhores livros de tecnologia do Brasil!</p>
				</div>

				<div class="row">

					<c:forEach items="${livros}" var="livro">
						<div class="col-6 col-sm-6 col-lg-4">
							<h4>${livro.titulo}</h4>
							<p>
								<a href="<c:url value="/loja/livro?id=${livro.id}" />"
									class="block clearfix"> <img
									src="<c:url value="/resources/imagens/medium_${livro.imagem}" />"
									alt="${livro.tituloCurto}" title="${livro.tituloCurto}">
								</a>
							<p>
								<a class="btn btn-default"
									href="<c:url value="/loja/livro?id=${livro.id}" />">Saiba
									mais &raquo;</a>
							</p>
						</div>
					</c:forEach>

				</div>
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