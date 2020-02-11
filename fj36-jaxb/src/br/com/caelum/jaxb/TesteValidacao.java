package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class TesteValidacao {

	public static void main(String[] args) throws JAXBException, SAXException, IOException {
		// TODO Auto-generated method stub
		Livro l = new Livro();
		l.setCodigo("arq");
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		JAXBSource source = new JAXBSource(context, l);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("schema.xsd"));
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new ValidationHandler());
		validator.validate(source);
	}

}
