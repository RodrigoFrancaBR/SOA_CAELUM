<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="row">
			<div class="col-md-9 col-xs-12">
				<div class="container">
					<form action="<c:url value="/carrinho/adicionarItem" />"
						method="post" class="container">
						<div class="row">
							<div class="col-md-2">

								<img
									src="<c:url value="/resources/imagens/medium_${livro.imagem}" />"
									alt="${livro.titulo}" class="img-rounded">
							</div>
							<div class="col-md-6">

								<input type="hidden" name="id" value="${livro.id}" />
								<h1>${livro.titulo }</h1>
								<h6>
									<input type="radio" name="formatoLivro" value="EBOOK">
									<label>E-book ${livro.valorEbook }</label>
								</h6>
								<h6>
									<input type="radio" name="formatoLivro" value="IMPRESSO"
										checked> <label>Impresso ${livro.valorImpresso }</label>
									<input class="btn-lg btn-primary text-center"
										style="margin-top: 1em; display: block" type="submit"
										class="icon-basket-alt" alt="Comprar" value="Comprar">
								</h6>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<h2>
									<span class="product-author-link">${livro.nomeAutor}</span>
								</h2>

								<span>
									<p>${livro.descricao}</p>
								</span>
							</div>
						</div>
					</form>
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
