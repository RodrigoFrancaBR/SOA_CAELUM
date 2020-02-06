package br.com.caelum.payfast.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.caelum.payfast.modelo.Pagamento;

@Path("/pagamentos")
@Singleton
public class PagamentoResource {
	private Map<Integer, Pagamento> repositorio = new HashMap<>();
	private Integer idPagamento = 1;

	public PagamentoResource() {

		Pagamento pagamento = new Pagamento();

		pagamento.setId(idPagamento++);
		pagamento.setValor(BigDecimal.TEN);
		pagamento.comStatusCriado();
		pagamento.setId(idPagamento++);

		repositorio.put(pagamento.getId(), pagamento);

	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML })
	Pagamento buscarPagamento(@PathParam("id") Integer id) {
		return repositorio.get(id);
	}
}