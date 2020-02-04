package br.com.caelum.livraria.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("request")
public class OAuthPasswordController {
	
	private static final String PASSWORD_GRANT_TOKEN_URL = "http://localhost:8080/fj36-webservice/oauth/password/token";
	
	@RequestMapping("/oauth/password/form")
	public String form(){
		return "oauth/form";
	}
	
	@RequestMapping(value="/oauth/password/token", method=RequestMethod.POST)
	public String token(String username, String password) throws Exception{
		return "redirect:/carrinho/criarPagamento";
	}
}
