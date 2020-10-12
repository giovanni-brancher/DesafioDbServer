package br.automationpractice.core;

/**
 * Propriedades do ambiente de testes.
 * 
 * @author Giovanni D. Brancher
 */
public class Propriedades {

	// Browser utilizado nos testes
	public static Browsers browser = Browsers.CHROME;

	public enum Browsers {
		CHROME, FIREFOX
	}

	public enum TipoTratamento {
		MR, MRS
	}
	
	public enum TipoSimNao {
		SIM, NAO
	}
	
	public enum TipoPagamento {
		TRANSF_BANCARIA, CHEQUE
	}
	
}
