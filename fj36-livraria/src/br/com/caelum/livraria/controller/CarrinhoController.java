package br.com.caelum.livraria.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.livraria.modelo.Carrinho;
import br.com.caelum.livraria.modelo.Formato;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Pagamento;
import br.com.caelum.livraria.modelo.Pedido;

@Controller
@RequestMapping("/carrinho")
@Scope("request")
public class CarrinhoController{
	
	private static final String JSP_CARRINHO_CONFIRMAR = "carrinho/confirmarPagamento";
	private static final String JSP_CARRINHO_LISTAR = "carrinho/listar";

	private static final String REDIRECT_CARRINHO_LISTAR = "redirect:/carrinho/listar";
	private static final String REDIRECT_CARRINHO_CONFIRMAR = "redirect:/carrinho/confirmarPagamento";

	@Autowired
	Carrinho carrinho;
	
	@PersistenceContext
	EntityManager manager;
	
	@RequestMapping("/adicionarItem")
	public String adicionarItemNoCarrinho(@RequestParam("id") Integer idLivro, 
											@RequestParam("formatoLivro") Formato formato)  {
		
		Livro livro = manager.find(Livro.class, idLivro);
		carrinho.adicionarOuIncremantarQuantidadeDoItem(livro, formato);

		return REDIRECT_CARRINHO_LISTAR;
	}

	@RequestMapping("/removerItem")
	public String removerItemNoCarrinho(@RequestParam("codigo") String codigo, 
											@RequestParam("formato") Formato formato, 
													RedirectAttributes modelo) {
		
		this.carrinho.removerItemPeloCodigoEFormato(codigo, formato);
		
		modelo.addFlashAttribute("messageInfo", "O item foi removido com sucesso.");
		
		return REDIRECT_CARRINHO_LISTAR;
	}
	
	@RequestMapping("/calcularCep")
	public String calcularCep(@RequestParam("cepDestino") String novoCepDestino) {
		
		this.carrinho.atualizarFrete(novoCepDestino);

		return REDIRECT_CARRINHO_LISTAR;
	}
	
	
	@RequestMapping("/criarPagamento")
	public String criarPagamento(String numeroCartao, 
								 String titularCartao, 
								 RedirectAttributes modelo) {
	
        if(!ehStringVazia(titularCartao) && !ehStringVazia(numeroCartao)){
			carrinho.setNumeroCartao(numeroCartao);
			carrinho.setTitularCartao(titularCartao);
		}
		if(!carrinho.temCartao()) {
			modelo.addFlashAttribute("messageWarn", "Por favor preenche os dados do cartão!");
			return REDIRECT_CARRINHO_LISTAR;
		}
        // Aqui fica o código de verificação do access token
        

		this.carrinho.criarPagamento(numeroCartao, titularCartao);

		if(this.carrinho.isPagamentoCriado()) {
			modelo.addFlashAttribute("messageInfo", "O seu pagamento foi criado! - Por favor confirme o pedido.");
		} else {
			modelo.addFlashAttribute("messageWarn", "Pagamento não foi criado!");
		}
		
		return REDIRECT_CARRINHO_CONFIRMAR;
	}
	
	@RequestMapping("/confirmarPagamento")
	public String confirmarPagamento() {
		return JSP_CARRINHO_CONFIRMAR;
	}


	private boolean ehStringVazia(String string) {
		return string == null || string.trim().isEmpty();
	}

	@RequestMapping("/finalizar")
	@Transactional
	public String finalizarPedido(RedirectAttributes modelo) {
		
		if(!carrinho.isFreteCalculado()) {
			modelo.addFlashAttribute("messageWarn", "O Frete deve ser calculado.");
			return REDIRECT_CARRINHO_LISTAR;
		}
		
		if(!carrinho.isPagamentoCriado()) {
			modelo.addFlashAttribute("messageWarn", "O pagamento deve ser aprovado antes.");
			return REDIRECT_CARRINHO_LISTAR;
		}

		Pedido pedido = this.carrinho.finalizarPedido();
		this.manager.persist(pedido);

		modelo.addFlashAttribute("messageInfo", "Pedido realizado. STATUS: " + pedido.getStatus());

		return REDIRECT_CARRINHO_LISTAR;
	}
	
	@RequestMapping("/listar")
	public String listar() throws Exception {
		//verificacao do estoque aqui
		this.carrinho.verificarDisponibilidadeDosItensComSoap();
		return JSP_CARRINHO_LISTAR;
	}
	
}

