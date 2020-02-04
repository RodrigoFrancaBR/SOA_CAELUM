package br.com.caelum.livraria.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Transacao  implements Serializable{

	private static final long serialVersionUID = 1L;

	private String numero;
	private String titular;
	private BigDecimal valor;

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public void setValor(final BigDecimal valor) {
		this.valor = valor;
	}

	public void setTitular(final String titular) {
		this.titular = titular;
	}
	
	public String getNumero() {
		return this.numero;
	}

	public String getTitular() {
		return this.titular;
	}


	public BigDecimal getValor() {
		return this.valor;
	}

	@Override
	public String toString() {
		return "Transacao [numero=" + this.numero + ", titular=" + this.titular +  ", valor="
				+ this.valor + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	

}
