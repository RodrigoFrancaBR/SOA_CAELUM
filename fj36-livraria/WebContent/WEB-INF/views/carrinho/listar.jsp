<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/carrinho/removerItem" var="linkCarrinhoRemover" />
<c:url value="/carrinho/finalizar" var="linkCarrinhoFinalizar" />
<c:url value="/carrinho/criarPagamento" var="linkCarrinhoCriarPagamento" />
<c:url value="/carrinho/calcularCep" var="linkCarrinhoCalcularCep" />

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
				<h2>Seu carrinho de compras</h2>

				<c:if test="${not empty messageInfo}">
					<div class="alert alert-info">${messageInfo}</div>
				</c:if>

				<c:if test="${not empty messageWarn}">
					<div class="alert alert-danger">${messageWarn}</div>
				</c:if>

				<c:if test="${empty carrinho.itensCompra}">
					<div class="alert alert-info">Nenhum livro no carrinho de
						compras.</div>

					<c:import url="/WEB-INF/views/compreMais.jsp" />

				</c:if>

				<c:if test="${not empty carrinho.itensCompra}">

					<table id="cart-table" class="table table-hover">

						<thead>
							<tr>
								<th width="65%" colspan="2">Livro</th>
								<th width="10%">Pre�o</th>
								<th width="5%">Qtd</th>
								<th width="5%">Estoque</th>
								<th width="10%">Total</th>
								<th width="5%"></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${carrinho.itensCompra}" var="item">
								<tr>
									<td><img
										src="<c:url value="/resources/imagens/small_${item.imagem}" />" /></td>
									<td>${item.titulo}(${item.formato})</td>
									<td class="numeric-cell">${item.valorUnico}</td>
									<td class="numeric-cell">${item.quantidade}</td>
									<td class="numeric-cell"><c:if test="${item.impresso}">${item.quantidadeEstoque}</c:if></td>
									<td class="numeric-cell">${item.total}</td>
									<td><a
										href="${linkCarrinhoRemover}?codigo=${item.codigo}&formato=${item.formato}"
										class="btn btn-default"> <span
											class="glyphicon glyphicon-trash"></span> Excluir
									</a></td>
								</tr>
							</c:forEach>
						</tbody>

						<tfoot>
							<c:if test="${carrinho.comLivrosImpressos}">
								<tr>
									<td></td>

									<td colspan="6" align="right">
										<form action="${linkCarrinhoCalcularCep}" method="post">
											<span class="input-group"> <span
												class="input-group-addon">CEP:</span> <input type="text"
												class="form-control" value="${carrinho.cepDestino}"
												name="cepDestino" id="cepDestino" placeholder="Digite o cep">
												<span class="input-group-btn">
													<button class="btn btn-default" type="submit">
														<span class="glyphicon glyphicon-usd"></span> Calcular
														Frete
													</button>
											</span>
											</span>
										</form>
									</td>
								</tr>
								<tr>
									<td colspan="4"></td>
									<td colspan="3" align="right"><c:if
											test="${not empty carrinho.valorFrete}">Frete: ${carrinho.valorFrete}</c:if></td>
								</tr>
							</c:if>

							<tr>
								<td colspan="4"><c:import
										url="/WEB-INF/views/compreMais.jsp" /></td>

								<td colspan="3" align="right"><strong>Total:
										${carrinho.total}</strong></td>
							</tr>

							<c:if test="${not carrinho.pagamentoCriado}">
								<tr id="tr_form_cartao">
									<td colspan="2"></td>
									<td colspan="5" align="right">
										<div id="div_form_cartao" class="show">
											<form action="${linkCarrinhoCriarPagamento}" method="POST"
												role="form">
												<p class="lead text-success">Preencha os dados abaixo:</p>
												<div class="form-group">
													<label for="cartao">N�mero do cart�o</label> <input
														type="text" class="form-control" name="numeroCartao"
														id="numeroCartao" placeholder="Digite o n�mero do cart�o"
														autocomplete="off">
												</div>
												<div class="form-group">
													<label for="nome">Nome do titular</label> <input
														type="text" class="form-control" name="titularCartao"
														id="titularCartao" placeholder="Digite o nome do titular"
														autocomplete="off">
												</div>
												<button type="submit" class="btn btn-success"
													name="btn_pagamento" id="btn_pagamento">
													<span class="glyphicon glyphicon-credit-card"></span> Pagar
													com PayFast
												</button>
											</form>
										</div>
									</td>
								</tr>
							</c:if>

							<c:if test="${carrinho.prontoParaSerFinalizado}">
								<tr>
									<td></td>
									<td colspan="6" align="right">
										<div id="divFinalizar">
											<form action="${linkCarrinhoFinalizar}" method="post">
												<button type="submit" class="btn btn-primary btn-lg"
													name="btn_pagamento" id="btn_pagamento">
													<span class="glyphicon glyphicon-check"></span> Finalizar
													pedido
												</button>
											</form>
										</div>
									</td>
								</tr>
							</c:if>
						</tfoot>
					</table>
				</c:if>
			</div>

			<div class="col-md-3 col-xs-12">
				<c:import url="/WEB-INF/views/menu-treinamentos.jsp" />
			</div>
		</div>

		<c:import url="/WEB-INF/views/footer.jsp" />

	</div>

	<script src="${jquery}"></script>

	<script src="${bootstrapjs}"></script>

	<script type="text/javascript">
		(function() {
			"use strict";

			var filtro = /[0-9]/;
			var inputs = document.querySelectorAll("#cepDestino");

			for ( var i = 0; i < inputs.length; i++) {

				inputs[i].addEventListener("keypress", function(event) {

					var digitado = String.fromCharCode(event.charCode);

					if (!filtro.test(digitado)) {
						event.preventDefault();
					}
				});
			}
		})();
	</script>

</body>
</html>