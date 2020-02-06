package br.com.caelum.estoque.ws;

import javax.xml.ws.WebFault;

@WebFault(name="AuthorizationFault")
public class AuthorizationException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorizationException(String message) {
		super(message);
	}

}
