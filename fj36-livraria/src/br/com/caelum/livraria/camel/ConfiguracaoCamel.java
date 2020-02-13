package br.com.caelum.livraria.camel;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfiguracaoCamel {
	
	@Autowired
	private CamelContext context;

	@PostConstruct
	void init() throws Exception {

		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("jms:topic:jms/TOPICO.LIVRARIA?username=jms&password=jms2")
						.log(LoggingLevel.INFO, "CAMEL: Recebendo MSG ${id}")
						.filter().xpath("/pedido/itens/item/formato[text()='EBOOK']")
						.split().xpath("/pedido/itens")
						.to("direct:notas")
						.log(LoggingLevel.INFO, "Camel: Recebendo msg ${id}")
						.filter().xpath("/pedido/itens")
					    .to("jms:queue:jms/FILA.GERADOR?username=jms&password=jms2");
				
				from ("direct:notas")
				.setHeader("data", constant(new SimpleDateFormat("dd/MM/yyyy").format(new Date())))
				.split().xpath("/pedido/pagamento")
				.convertBodyTo(String.class)
				.to("velocity:nota.vm")
				.log(LoggingLevel.INFO, "CAMEL: MSG transformando com velocity ${body}");

			}

		});

		context.start();

	}

	@PreDestroy
	void destroy() throws Exception {
		context.stop();
	}

}
