package br.com.caelum.camel;

import java.util.List;
import java.util.Scanner;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import br.com.caelum.livraria.modelo.Livro;

public class TestePolling {

	public static void main(String[] args) throws Exception {
		MysqlConnectionPoolDataSource mysql = new MysqlConnectionPoolDataSource();
		mysql.setDatabaseName("fj36_camel");
		mysql.setServerName("localhost");
		mysql.setPort(3306);
		mysql.setUser("root");
		mysql.setPassword("");
		
		JndiContext jndiContext = new JndiContext();
		jndiContext.rebind("mysqlDataSource", mysql);
		
		DefaultCamelContext context = new DefaultCamelContext(jndiContext);
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("http://localhost:8088/fj36-livraria/loja/livros/mais-vendidos")
					.delay(1000)
					.unmarshal()
					.json()
					.process(new Processor() {
								@Override
								public void process(Exchange e) throws Exception {
									List<?> body = (List<?>) e.getIn().getBody();
									List<Livro> livros = (List<Livro>) body.get(0);
									Message message = e.getIn();
									message.setBody(livros);	
								}
							})
					.log("${body}")
				// .to("mock:livros");
				.to("direct:livros");
				
				
				from("direct:livros")
				.split(body())
				.process(new Processor() {
					
					@Override
					public void process(Exchange e) throws Exception {
						Message message = e.getIn();
						Livro livro = (Livro) message.getBody();
						String autor = livro.getNomeAutor();
						message.setHeader("autor", autor.toString());
			
						
						
					}
				})
				.setBody(simple("insert into Livros (nomeAutor) values (':?autor')"))
				.to("jdbc:mysqlDataSource?useHeadersAsParameters=true");
			}
		});
		context.start();
		new Scanner(System.in).nextLine();
		context.stop();
	}

}
