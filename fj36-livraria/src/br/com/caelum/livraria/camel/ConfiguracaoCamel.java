package br.com.caelum.livraria.camel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ConfiguracaoCamel {


	@PostConstruct
	void init() throws Exception {

	}
	
	@PreDestroy
	void destroy() throws Exception {

	}

}
