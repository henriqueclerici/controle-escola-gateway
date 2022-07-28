package br.com.totvs.gateway.exception;

public abstract class ControleEscolaException extends Exception {


	private static final long serialVersionUID = 155478446712218568L;

	public ControleEscolaException() {
		super();
	}

	public ControleEscolaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControleEscolaException(String message) {
		super(message);
	}

	public ControleEscolaException(Throwable cause) {
		super(cause);
	}
	
	

}
