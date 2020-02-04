package br.com.caelum.livraria.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Integer id;
	private Formato formato;
	private Integer quantidade;
	private Integer quantidadeEstoque;
	
	@ManyToOne
	private Livro livro;
	
	ItemCompra() {
	}

	public ItemCompra(Livro livro, Formato formato) {
		this.livro = livro;
		this.formato = formato;
		this.quantidade = 1;
		this.quantidadeEstoque = 0;
	}
	
	public void incrementaQuantidade(Integer quantidade) {
		this.quantidade += quantidade;
	}

	public boolean isImpresso() {
		return formato.equals(Formato.IMPRESSO);
	}

	public String getImagem() {
		return this.livro.getImagem();
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public BigDecimal getValorUnico() {
		return this.livro.getValor(formato);
	}

	public String getTitulo() {
		return this.livro.getTitulo();
	}

	public String getCodigo() {
		return this.livro.getCodigo();
	}

	public BigDecimal getTotal() {
		BigDecimal valorLivro = this.getValorUnico();
		return valorLivro.multiply(new BigDecimal(this.quantidade));
	}

	public Formato getFormato() {
		return formato;
	}

	public void setQuantidadeNoEstoque(Integer quantidade) {
		quantidadeEstoque = quantidade;
	}

	public boolean temCodigo(String codigo) {
		return this.getCodigo().equals(codigo);
	}

	@Override
	public String toString() {
		return "ItemCompra [titulo=" + this.livro.getTitulo() + ", image=" + this.livro.getImagem() + ", codigo=" + this.livro.getCodigo()
				+ ", formato=" + formato + ", quantidade=" + quantidade + ", quantidadeEstoque="
				+ quantidadeEstoque + ", valorUnico=" + livro.getValor(formato) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.livro.getCodigo() == null) ? 0 : this.livro.getCodigo().hashCode());
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompra other = (ItemCompra) obj;
		if (this.livro.getCodigo() == null) {
			if (other.livro.getCodigo() != null)
				return false;
		} else if (!this.livro.getCodigo().equals(other.livro.getCodigo()))
			return false;
		if (formato != other.formato)
			return false;
		return true;
	}
}
