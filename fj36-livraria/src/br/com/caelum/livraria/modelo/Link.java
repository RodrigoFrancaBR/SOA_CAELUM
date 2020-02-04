package br.com.caelum.livraria.modelo;

import java.io.Serializable;

public class Link implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rel;
	private String uri;
	private String method;

	Link() { //apenas para agradar JAX-B
	}

	public Link(String rel, String uri, String method) {
		this.rel = rel;
		this.uri = uri;
		this.method = method;
	}

	public String getRel() {
		return rel;
	}

	public String getUri() {
		return uri;
	}

	public String getMethod() {
		return method;
	}

	@Override
	public String toString() {
		return "Link [rel=" + rel + ", uri=" + uri + ", method=" + method + "]";
	}

}
