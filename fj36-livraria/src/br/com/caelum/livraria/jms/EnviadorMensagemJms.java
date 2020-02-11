package br.com.caelum.livraria.jms;

import java.io.Serializable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;
import javax.sql.rowset.serial.SerialArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.jaxb.SerializadorXml;
import br.com.caelum.livraria.modelo.Pedido;

@Component
@Lazy(true)
public class EnviadorMensagemJms implements Serializable {

	@Autowired
	private ConnectionFactory factory;

	@Autowired
	private Topic topic;

	private static final long serialVersionUID = 1L;

	public void enviar(Pedido pedido) {
		System.out.println("JMS: Enviando pedido:" + pedido);
		String xml = new SerializadorXml().toXml(pedido);
		try (JMSContext context = factory.createContext("jms", "jms2")) {
			JMSProducer producer = context.createProducer();
			producer.setProperty("formato", pedido.getFormato());
			System.out.println(xml);
			producer.send(topic, xml);
		}
	}
}
