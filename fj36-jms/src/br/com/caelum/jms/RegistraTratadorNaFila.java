package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistraTratadorNaFila {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Queue queue = (Queue) ic.lookup("jms/FILA.GERADOR");
		JMSContext context = factory.createContext("jms", "jms2");
		JMSConsumer consumer = context.createConsumer(queue);
		consumer.setMessageListener(new TratadorDeMensagem());
		context.start();
		Scanner tc = new Scanner(System.in);
		System.out.println("Tratador esperando as mensagens na fila JMS");
		tc.nextLine();
		tc.close();
		context.stop();

	}
}
