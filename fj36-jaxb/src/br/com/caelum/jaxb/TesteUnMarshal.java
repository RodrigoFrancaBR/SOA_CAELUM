package br.com.caelum.jaxb;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TesteUnMarshal {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {

		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Unmarshaller u = context.createUnmarshaller();
		Livro unmarshal = (Livro) u.unmarshal(new File("livro.xml"));
		System.out.println(unmarshal.getTitulo());
	}
}
