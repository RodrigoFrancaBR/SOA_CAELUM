package br.com.caelum.estoque.ws;

public class ItemEstoque {
	String codigo;
	int quantidade;

	public ItemEstoque(String codigo, int quantidade) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
	}

	public ItemEstoque() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
