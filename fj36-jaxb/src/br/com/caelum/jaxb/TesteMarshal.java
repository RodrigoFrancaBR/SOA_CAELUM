package br.com.caelum.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TesteMarshal {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		Livro livro = new Livro();
		livro.setCodigo("AARQ");
		livro.setTitulo("Arquitetura");
		livro.setNomeAutor("Paulo");
		livro.setValor(new BigDecimal("29.90"));

		Categoria c = new Categoria();
		c.setNome("TI");
		livro.setCategoria(c);

		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Marshaller m = context.createMarshaller();
		m.marshal(livro, new FileOutputStream("livro.xml"));
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	}
}
