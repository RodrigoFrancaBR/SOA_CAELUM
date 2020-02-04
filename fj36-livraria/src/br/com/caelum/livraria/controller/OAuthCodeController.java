package br.com.caelum.livraria.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("request")
public class OAuthCodeController {

	private static final String REDIRECT_URL = "http://localhost:8088/fj36-livraria/oauth/code/returnURL";
	
	private static final String AUTH_CODE_FORM_URL = "http://localhost:8080/fj36-webservice/oauth/code/form";
	
	private static final String AUTH_CODE_TOKEN_URL = "http://localhost:8080/fj36-webservice/oauth/code/token";

	@RequestMapping("/oauth/code") //callback
	public String redirectToPayfast() throws Exception {
		String oauthURI = "";
		return "redirect:" + oauthURI;
	}
	
	@RequestMapping("/oauth/code/returnURL")
	public String oauthReturn(HttpServletRequest request) throws Exception{
		return "redirect:/carrinho/criarPagamento";
	}
}
