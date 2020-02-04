<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value="/loja/index" />">Home</a></li>
				<li><a href="http://caelum.com.br">Caelum</a></li>
				<li><a href="http://alura.com.br">Alura</a></li>
				<li><a href="http://casadocodigo.com.br">Casa de código</a></li>
				<li><a href="<c:url value="/carrinho/listar" />"
					class="btn btn-default btn-xs"> <span
						class="glyphicon glyphicon-shopping-cart"></span> Carrinho
				</a></li>
			</ul>
		</div>
	</div>
</div>