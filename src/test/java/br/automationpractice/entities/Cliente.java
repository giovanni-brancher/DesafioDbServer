package br.automationpractice.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.automationpractice.core.Propriedades.TipoPagamento;
import br.automationpractice.core.Propriedades.TipoSimNao;
import br.automationpractice.core.Propriedades.TipoTratamento;

/**
 * Entidade Cliente
 * 
 * @author Giovanni D. Brancher
 */
public class Cliente {
	
	private TipoTratamento tipoTratamento;
	private String primeiroNome;
	private String ultimoNome;
	private String email;
	private String senha;
	private String dataNascimento;
	private TipoSimNao assinarNewsletter;
	private TipoSimNao receberOfertasDeParceiros;
	private Endereco endereco;
	private Contato contato;
	private List<Produto> carrinhoItens;
	private TipoPagamento tipoPagamento;
	
	public TipoTratamento getTipoTratamento() {
		return tipoTratamento;
	}

	public void setTipoTratamento(TipoTratamento tipoTratamento) {
		this.tipoTratamento = tipoTratamento;
	}
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	public String getUltimoNome() {
		return ultimoNome;
	}
	
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public TipoSimNao getAssinarNewsletter() {
		return assinarNewsletter;
	}
	
	public void setAssinarNewsletter(TipoSimNao assinarNewsletter) {
		this.assinarNewsletter = assinarNewsletter;
	}
	
	public TipoSimNao getReceberOfertasDeParceiros() {
		return receberOfertasDeParceiros;
	}
	
	public void setReceberOfertasDeParceiros(TipoSimNao receberOfertasDeParceiros) {
		this.receberOfertasDeParceiros = receberOfertasDeParceiros;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public List<Produto> getCarrinhoItens() {
		return carrinhoItens;
	}
	
	public void setCarrinhoItens(List<Produto> carrinhoItens) {
		this.carrinhoItens = carrinhoItens;
	}
	
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	/**
	 * Popula o cliente com dados obrigatórios de cadastro.
	 */
	public void setDadosObrigatorios() {
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
		
		this.setTipoTratamento(TipoTratamento.MR);
		this.setPrimeiroNome("Giovanni");
		this.setUltimoNome("Brancher");
		this.setEmail("giovanni@"+timeStamp+".com");
		this.setSenha("0123456789");

		this.setEndereco(new Endereco());
		this.getEndereco().setEnderecoPrincipal("Broadway 934");
		this.getEndereco().setCidade("Oakland");
		this.getEndereco().setEstado("Florida");
		this.getEndereco().setCodigoPostal("90010");
		this.getEndereco().setPais("United States");
		this.getEndereco().setIdentificadorEndereco("Minha casa");
		
		this.setContato(new Contato());
		this.getContato().setFoneCelular("99998888");
		
		this.carrinhoItens = new ArrayList<Produto>();
		this.setTipoPagamento(TipoPagamento.TRANSF_BANCARIA);
	}
	
}
