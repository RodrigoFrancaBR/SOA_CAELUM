	package br.com.caelum.livraria.jms;

import java.io.Serializable;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.modelo.Pedido;

@Component
@Lazy(true)
public class EnviadorMensagemJms implements Serializable {
	
	@Autowired
	private ConnectionFactory fc ;
	
	@Autowired
	private Topic topic ;
	
	private static final long serialVersionUID = 1L;

	public void enviar(Pedido pedido) {
		System.out.println("");
	}
}
