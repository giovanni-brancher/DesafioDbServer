package br.automationpractice.entities;

/**
 * Entidade Endereco
 * 
 * @author Giovanni D. Brancher
 */
public class Endereco {
	
	private String companhia;
	private String enderecoPrincipal;
	private String cidade;
	private String estado;
	private String codigoPostal;
	private String pais;
	private String infoAdicional;
	private String identificadorEndereco;
	
	public String getCompanhia() {
		return companhia;
	}

	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}

	public String getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(String enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getIdentificadorEndereco() {
		return identificadorEndereco;
	}

	public void setIdentificadorEndereco(String identificadorEndereco) {
		this.identificadorEndereco = identificadorEndereco;
	}
	
}
