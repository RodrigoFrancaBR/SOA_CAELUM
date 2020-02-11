package br.com.caelum.jaxb;

import javax.xml.bind.annotation.XmlType;

//@XmlType(name = "CAT")
public class Categoria {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
