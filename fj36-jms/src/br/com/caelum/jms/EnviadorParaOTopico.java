package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviadorParaOTopico {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topic = (Topic) ic.lookup("jms/TOPICO.LIVRARIA");
		try (JMSContext context = cf.createContext("jms", "jms2")) {
			JMSProducer createProducer = context.createProducer();
			createProducer.setProperty("formato", "ebook");
			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				String line = (String) sc.nextLine();
				createProducer.send(topic, line);
			}
			sc.close();
		}
	}
}
