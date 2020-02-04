package br.com.caelum.livraria.util;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import br.com.caelum.livraria.modelo.Livro;

@Component
public class PopulaBanco {
	
	@PersistenceContext
	EntityManager manager;
	
	@Autowired
    @Qualifier("transactionManager")
    protected PlatformTransactionManager txManager;
	
	
	/*
	 * Método é executado automaticamente quando o Spring sobe o contexto da aplicação
	 */
    @PostConstruct
    private void init(){
    	//métodos @PostConstruct não são transacional, por isso gerenciamos a TX manualmente
        TransactionTemplate tmpl = new TransactionTemplate(txManager);
        tmpl.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
            	PopulaBanco.this.roda();
            }
        });
   }

	public void roda() { 
		Livro webMobile = geraLivro(
				"WEB",
				"A Web Mobile: Programe para um mundo de muitos dispositivos",
				"A Web Mobile",
				"Sérgio Lopes",
				"Com o crescimento absurdo do uso de smartphones e tablets, A Web quebrou novas fronteiras. Sites enjaulados no Desktop são coisa do passado. "
				+ "A Web é multidispositivo e você precisa suportar mobile, TV, relógio... e até Desktop! <br />Programe a Web moderna, transformada pela mobilidade, "
				+ "touch screens e plataformas diversas. Desvende os mistérios de um bom design responsivo, de uma estratégia mobile-first, das telas de alta resolução, "
				+ "dos componentes HTML5 e das otimizações de performance. Enfrente os desafios e mudanças da Web Mobile e explore seus limites!",
				"webmobile.png", "29.90", "69.90");

		Livro arquitetura = geraLivro(
				"ARQ",
				"Introdução à Arquitetura e Design de Software",
				"Arquitetura Java",
				"Paulo Silveira",
				"Neste livro, os autores, conhecidos especialistas da área, apresentam muitos tópicos que aparecem com frequência na plataforma Java, "
				+ "incluindo desde modelagem e design das classes, até detalhes importantes das tecnologias mais utilizadas. <br/> "
				+ "Sempre com uma visão técnica e prática capaz de elucidar muitas questões enfrentadas tanto pelo profissional iniciante quanto "
				+ "por aquele que está adquirindo mais experiência na plataforma.",
				"arquitetura.jpg", "29.90", "79.90");
		
		Livro rest = geraLivro(
				"RES",
				"REST: Construa API's inteligentes de maneira simples",
				"REST",
				"Alexandre Saudate",
				"De alguma maneira, os sistemas modernos precisam se integrar com outros sistemas, "
				+ "seja para coletar dados, enviar informações, autenticação e muito mais funcionalidades. "
				+ "Nesse livro, Alexandre Saudate ensina como implementar APIs REST, que são simples e fáceis de manter, "
				+ "indo desde o básico dos formatos de dados como XML e JSON, passando por uma implementação rústica de um serviço "
				+ "e evoluindo para uso da poderosa especificação Java, o JAX-RS.",
				"rest.png", "29.90", "59.90");
		
		Livro tdd = geraLivro(
				"TDD",
				"Test-Driven Development: Teste e Design no Mundo Real",
				"TDD",
				"Mauricio Aniche",
				"Por que não testamos software? Por que é caro? Por que é demorado? Por que é chato? Testes automatizados são a solução para todos esses problemas. "
				+ "Aprenda a escrever um programa que testa seu programa de forma rápida, barata e produtiva, e aumente a qualidade do seu produto final. \\n "
				+ "Neste livro, você aprenderá sobre TDD, uma das práticas ágeis de desenvolvimento de software mais populares, através da linguagem Java, "
				+ "mas poderá aplicar o conceito aprendido em qualquer outra linguagem. TDD faz o desenvolvedor escrever o teste antes mesmo de implementar o código. "
				+ "Essa simples inversão na maneira de se trabalhar, faz com o que o desenvolvedor escreva código mais testado, com menos bugs, "
				+ "e inclusive com mais qualidade. Seja profissional, teste seu software!",
				"tdd.png", "29.90", "59.90");		

		Livro soa = geraLivro(
				"SOA",
				"SOA aplicado: Integrando com web services e além",
				"SOA",
				"Alexandre Saudate",
				"Cada vez mais, sistemas corporativos exigem o reaproveitamento de funcionalidades, e consequentemente a integração entre diferentes sistemas "
				+ "se torna uma realidade. Essa é uma tendência natural das arquiteturas modernas. "
				+ "A arquitetura orientada a serviços (Service Oriented Architecture - SOA) existe justamente para resolver essa situação. "
				+ "Aprenda como integrar sistemas com web services, mensageria assíncrona, orquestração e muito mais de uma maneira prática, "
				+ "focada, onde desde primeiro capítulo você já constrói e se integra a um serviço.",
				"soa.png", "29.90", "59.90");	
		
		Livro logica = geraLivro(
				"LOG",
				"Lógica de Programação: Crie seus primeiros programas usando Javascript e HTML",
				"Lógica",
				"Adriano Almeida",
				"Aprenda a programar agora! Com uma abordagem totalmente prática, uma didática pensada no iniciante, onde os conceitos são apresentados "
				+ "com motivações práticas, através do surgimento da necessidade para depois mostrar a solução."
				+ "Com apenas um navegador e um editor de textos você estará pronto para criar seus primeiros programas de computador. Lógica de programação "
				+ "e comandos como o if, for e while são motivados através de problemas que vivemos no nosso dia a dia, dessa forma, ganha-se familiaridade "
				+ "com as instruções das linguagens de programação desde o começo do aprendizado!"
				+ "O livro explora os recursos do HTML e Javascript, criando a familiaridade desde o começo dos estudos com a sintaxe da linguagem de programação, "
				+ "instruções, funções específicas e problemas corriqueiros da programação. Além disso, você vai aprender como usar o Canvas do HTML "
				+ "para criar seus desenhos através de programação e impressionar seus amigos.",
				"logica.png", "29.90", "59.90");
		
		manager.persist(arquitetura);
		manager.persist(soa);
		manager.persist(webMobile);
		manager.persist(rest);
		manager.persist(tdd);
		manager.persist(logica);
		
	}

	private static Livro geraLivro(String codigo, String titulo, String tituloCurto,
			String nomeAutor, String descricao, String imagem,
			String valorEbook, String valorImpresso) {

		return new Livro(codigo, titulo, tituloCurto, descricao, nomeAutor, imagem,
				new BigDecimal(valorEbook), new BigDecimal(valorImpresso));
	}
}
