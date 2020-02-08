package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviadorParaFila {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Queue queue = (Queue) ic.lookup("jms/FILA.GERADOR");
		try (JMSContext context = cf.createContext("jms", "jms2")) {
			JMSProducer createProducer = context.createProducer();
			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				String line = (String) sc.nextLine();
				createProducer.send(queue, line);
			}
			sc.close();
		}
	}
}
