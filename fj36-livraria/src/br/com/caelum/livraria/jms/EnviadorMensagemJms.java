package br.com.caelum.livraria.jms;

import java.io.Serializable;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.jaxb.SerializadorXml;
import br.com.caelum.livraria.modelo.Pedido;

@Component
@Lazy(true)
public class EnviadorMensagemJms implements Serializable {

	private static final long serialVersionUID = 1L;

	public void enviar(Pedido pedido) {
		// código para enviar a mensagem
	}
}
