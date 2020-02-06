package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.jboss.security.authorization.AuthorizationException;

@WebService(targetNamespace="http://caelum.com.br/estoquews/v1")
@Stateless
public class EstoqueWS {

	private Map<String, ItemEstoque> repositorio = new HashMap<>();

	public EstoqueWS() {
		repositorio.put("ARQ", new ItemEstoque("ARQ", 5));
		repositorio.put("SOA", new ItemEstoque("SOA", 2));
		repositorio.put("TDD", new ItemEstoque("TDD", 3));
		repositorio.put("RES", new ItemEstoque("LOGRES", 4));
		repositorio.put("LOG", new ItemEstoque("ARQ", 3));
		repositorio.put("WEB", new ItemEstoque("WEB", 4));
	}

	@WebMethod(operationName="ItensPeloCodigo")
	@WebResult(name="ItemEstoque")
	public List<ItemEstoque> getQuantidade(@WebParam (name="token", header =true)String token, @WebParam (name="codigo")List<String> codigos) throws AuthorizationException {
		
		if (token == null || !token.equals("TOKEN123")) {
			throw new AuthorizationException("Não autorizado") ;
		}
		
		List<ItemEstoque> itens = new ArrayList<>();
		if (codigos == null || codigos.isEmpty()) {
			return itens;
		}

		for (String codigo : codigos) {
			if (repositorio.containsKey(codigo)) {
				itens.add(repositorio.get(codigo));
			}
		}
		return itens;

	}
}
