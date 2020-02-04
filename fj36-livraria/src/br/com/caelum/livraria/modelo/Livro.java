package br.com.caelum.livraria.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private String titulo;
	private String tituloCurto;
	private String nomeAutor;
	private String imagem;
	private BigDecimal valorEbook;
	private BigDecimal valorImpresso; 

	@Column(length=1000) 
	private String descricao;

	Livro() {}//só para hibernate ficar feliz
	
	public Livro(String codigo, String titulo, String tituloCurto, String descricao,
			String nomeAutor, String imagem, BigDecimal valorEbook,
			BigDecimal valorImpresso) {

		this.codigo = codigo;
		this.titulo = titulo;
		this.tituloCurto = tituloCurto;
		this.descricao = descricao;
		this.nomeAutor = nomeAutor;
		this.imagem = imagem;
		this.valorEbook = valorEbook;
		this.valorImpresso = valorImpresso;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTituloCurto() {
		return tituloCurto;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getImagem() {
		return imagem;
	}

	public BigDecimal getValorEbook() {
		return valorEbook;
	}

	public BigDecimal getValorImpresso() {
		return valorImpresso;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTituloCurto(String tituloCurto) {
		this.tituloCurto = tituloCurto;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setValorEbook(BigDecimal valorEbook) {
		this.valorEbook = valorEbook;
	}

	public void setValorImpresso(BigDecimal valorImpresso) {
		this.valorImpresso = valorImpresso;
	}

	public BigDecimal getValor(Formato formato) {
		if(formato.equals(Formato.EBOOK)) {
			return this.valorEbook;
		}
		return this.valorImpresso;
	}

	public String getCodigo() {
		return this.codigo;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", tituloCurto="
				+ tituloCurto + ", nomeAutor=" + nomeAutor + ", imagem=" + imagem + ", valorEbook="
				+ valorEbook + ", valorImpresso=" + valorImpresso + ", descricao=" + descricao
				+ "]";
	}
	
}
