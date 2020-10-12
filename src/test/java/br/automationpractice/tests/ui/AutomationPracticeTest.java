package br.automationpractice.tests.ui;

import org.junit.Test;

import br.automationpractice.core.BaseTest;
import br.automationpractice.entities.Cliente;
import br.automationpractice.pages.AutomationPracticePage;

/**
 * Classe de testes do ecommerce Automation Practice.
 * 
 * @author Giovanni D. Brancher
 */
public class AutomationPracticeTest extends BaseTest {
	
	private Cliente cliente = new Cliente();
	private AutomationPracticePage autoPracticePage = new AutomationPracticePage();
	
	/**
	 * Deve realizar a compra de um produto qualquer com sucesso.
	 */
	@Test
	public void deveComprarProdutoQualquerComSucesso() {
		this.cliente.setDadosObrigatorios();
		this.autoPracticePage.acessarProdutoMaisPopular();
		this.autoPracticePage.adicionarProdutoNoCarrinho(this.cliente, 20, "M");
		this.autoPracticePage.verificarResumoCarrinho(this.cliente);
		this.autoPracticePage.cadastrarCliente(this.cliente);
		this.autoPracticePage.validarEnderecoEntrega(this.cliente);
		this.autoPracticePage.aceitarTermosCompromisso();
		this.autoPracticePage.escolherFormaDePagamento(this.cliente);
		this.autoPracticePage.validarPedidoDeCompra(this.cliente);
	}
	
}
