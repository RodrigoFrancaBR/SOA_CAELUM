package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class TesteGeraSchema {
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext newInstance = JAXBContext.newInstance(Livro.class);
		newInstance.generateSchema(new SchemaOutputResolver() {

			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
				StreamResult streamResult = new StreamResult(new File("schema.xsd"));
				return streamResult;
			}
		});
	}
}
