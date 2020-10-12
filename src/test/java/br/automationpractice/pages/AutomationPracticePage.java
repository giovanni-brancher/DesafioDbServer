package br.automationpractice.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import br.automationpractice.core.BasePage;
import br.automationpractice.core.Propriedades.TipoPagamento;
import br.automationpractice.core.Propriedades.TipoSimNao;
import br.automationpractice.core.Propriedades.TipoTratamento;
import br.automationpractice.core.Utils;
import br.automationpractice.entities.Cliente;
import br.automationpractice.entities.Contato;
import br.automationpractice.entities.Endereco;
import br.automationpractice.entities.Produto;

/**
 * Page Object e validações
 * 
 * @author Giovanni D. Brancher
 */
public class AutomationPracticePage extends BasePage {

	// Página inicial
	private By linkProdutoMaisPopular = By.cssSelector("ul.homefeatured li:first-child a[class='product-name']");

	// Página produto
	private By textoTituloProduto = By.cssSelector("h1[itemprop='name']");
	private By textoPrecoProduto = By.cssSelector("span[itemprop='price']");
	private By textoCorProduto = By.cssSelector("#color_to_pick_list li[class='selected'] a");
	private By comboTamanhoProduto = By.cssSelector("#uniform-group_1 > select");
	private By campoQuantidadeProduto = By.cssSelector("#quantity_wanted");
	private By botaoAdicionarProdutoCarrinho = By.cssSelector("#add_to_cart > button[type='submit']");
	private By botaoProsseguirParaCheckout = By.cssSelector(".button-container > a[title='Proceed to checkout']");
	private By botaoProsseguirEtapaResumoCarrinho = By.cssSelector(".cart_navigation > a[title='Proceed to checkout']");
	
	private By textoCorTamanhoProdutoModal = By.cssSelector("#layer_cart_product_attributes");
	private By textoQtdProdutosModal = By.cssSelector("#layer_cart_product_quantity");
	private By textoValorSemFreteModal = By.cssSelector("#layer_cart_product_price");
	private By textoValorComFreteModal = By.cssSelector(".layer_cart_row .ajax_block_cart_total");
	private By textoValorFreteModal = By.cssSelector(".layer_cart_row .ajax_cart_shipping_cost");
	private By linhasTabelaResumoCarrinho = By.cssSelector("#cart_summary tbody > tr");

	// Página pré-cadastro e login
	private By campoEmailPreCadastro = By.cssSelector("input[name='email_create']");
	private By botaoCadastrarCliente = By.cssSelector("#SubmitCreate");

	// Página cadastro de usuário
	private By etapaCorrente = By.cssSelector("#order_step > li[class*=step_current]");
	private By radioTipoTratamentoMr = By.cssSelector("#id_gender1");
	private By radioTipoTratamentoMra = By.cssSelector("#id_gender2");
	private By campoPrimeiroNome = By.cssSelector("#customer_firstname");
	private By campoUltimoNome = By.cssSelector("#customer_lastname");
	private By campoEmail = By.cssSelector("#email"); // fazer validação
	private By campoSenha = By.cssSelector("#passwd");
	private By campoPrimeiroNomeDestinatario = By.cssSelector("#firstname"); // fazer validação
	private By campoUltimoNomeDestinatario = By.cssSelector("#lastname"); // fazer validação
	private By campoEndereco = By.cssSelector("#address1");
	private By campoCidade = By.cssSelector("#city");
	private By campoCodigoPostal = By.cssSelector("#postcode");
	private By campoFoneCelular = By.cssSelector("#phone_mobile");
	private By campoIdentificadorEndereco = By.cssSelector("#alias");
	private By comboEstado = By.cssSelector("#id_state");
	private By comboPais = By.cssSelector("#id_country");
	private By checkboxAssinarNewsletter = By.cssSelector("#newsletter");
	private By checkboxReceberOfertasDeParceiros = By.cssSelector("#optin");
	private By botaoProsseguirEtapaCadastroCliente = By.cssSelector("#submitAccount");

	// Etapa de confirmação de endereço
	private By textoNomeSobrenomeDestinatario = By.cssSelector("#address_delivery > li.address_firstname.address_lastname");
	private By textoEnderecoDestinatario = By.cssSelector("#address_delivery > li.address_address1.address_address2");
	private By textoCidadeEstadoCodPostalDestinatario = By.cssSelector("#address_delivery > li.address_city.address_state_name.address_postcode");
	private By textoPaisDestinatario = By.cssSelector("#address_delivery > li.address_country_name");
	private By textoFoneCelularDestinatario = By.cssSelector("#address_delivery > li.address_phone_mobile");
	private By botaoProsseguirEtapaConfirmacaoDestinatario = By.cssSelector("button[name='processAddress']");

	// Etapa forma de entrega
	private By checkboxTermosDeServico = By.cssSelector("#uniform-cgv");
	private By botaoProsseguirEtapaFormaEntrega = By.cssSelector("button[name='processCarrier']");

	// Etapa de pagamento
	private By textoValorTotalProduto = By.cssSelector("#total_product");
	private By textoValorFrete = By.cssSelector("#total_shipping");
	private By textoValorFinal = By.cssSelector("#total_price");
	private By botaoTipoPagamentoTransferenciaBancaria = By.cssSelector("#HOOK_PAYMENT a[class='bankwire']");
	private By botaoTipoPagamentoCheque = By.cssSelector("#HOOK_PAYMENT a[class='cheque']");
	private By botaoConfirmarOrdemDeCompra = By.cssSelector(".cart_navigation > button[type=submit]");

	// Tela informativa após pagamento
	private By mensagemProcessoCompraCompletada = By.cssSelector("#center_column strong[class='dark']");
	private By textoInformativoPosOrdemDeCompra = By.cssSelector("#center_column > div[class='box']");
	private By textoCodigoOrdemPedido = By.cssSelector("#order-list tbody td.history_link a");
	private By botaoVisualizarMinhaConta = By.cssSelector("a[title='View my customer account']");
	private By botaoHistoricoPedidos = By.cssSelector("li > a[title='Orders']");
	private By botaoExibirHistoricoProduto = By.cssSelector("#order-list tbody td.history_link a");
	private By tabelaDadosProduto = By.cssSelector("#order-detail-content > table");
	private By textoInfoProduto = By.cssSelector("#block-order-detail > form tbody > tr > td:nth-child(2) > label");
	private By textoQtdProduto = By.cssSelector("#block-order-detail > form tbody > tr > td:nth-child(3) > label");
	private By textoValorUnitarioProduto = By.cssSelector("#block-order-detail > form tbody > tr > td:nth-child(4) > label");
	private By textoValorSemFreteProduto = By.cssSelector("#block-order-detail > form tbody > tr > td:nth-child(5) > label");
	private By textoValorFreteProduto = By.cssSelector("#block-order-detail > form tfoot tr:nth-child(3) > td:nth-child(2)");
	private By textoValorComFreteProduto = By.cssSelector("#block-order-detail > form tfoot tr:nth-child(4) > td:nth-child(2)");

	public void acessarProdutoMaisPopular()
	{
		clicar(linkProdutoMaisPopular);
	}

	public void adicionarProdutoNoCarrinho(Cliente cli, Integer quantidade, String tamanho)
	{
		Produto produto = new Produto();
		produto.setTitulo(obterTexto(textoTituloProduto));
		produto.setPreco(obterTexto(textoPrecoProduto));
		produto.setCor(obterAtributoDoElemento(textoCorProduto, "title"));
		produto.setTamanho(tamanho);
		produto.setQuantidade(quantidade);
		
		escrever(campoQuantidadeProduto, quantidade);
		selecionarCombo(comboTamanhoProduto, tamanho);
		
		cli.getCarrinhoItens().add(produto);
		clicar(botaoAdicionarProdutoCarrinho);
		
		// Validações no modal de confirmação
		String corTamanho[] = obterTexto(textoCorTamanhoProdutoModal).split(", ");
		assertEquals(produto.getCor(), corTamanho[0]);
		assertEquals(produto.getTamanho(), corTamanho[1]);
		
		String qtdProduto = obterTexto(textoQtdProdutosModal);
		assertEquals(produto.getQuantidade(), new Integer(Integer.parseInt(qtdProduto)));
		
		String valorSemFreteExibido = obterTexto(textoValorSemFreteModal);
		String valorSemFreteEsperado = obterValorTotalItensSemFrete(produto.getPreco(), quantidade);		
		assertEquals(valorSemFreteEsperado, valorSemFreteExibido);
		
		String valorComFreteExibido = obterTexto(textoValorComFreteModal);
		String valorFrete = obterTexto(textoValorFreteModal);
		Float valorComFreteEsperado = obterValorDecimal(valorSemFreteExibido) + obterValorDecimal(valorFrete);
		assertEquals(Utils.adicionarMascaraMoedaDolar(valorComFreteEsperado), valorComFreteExibido);
		
		clicar(botaoProsseguirParaCheckout);
	}
	
	public void verificarResumoCarrinho(Cliente cli)
	{
		// Valida etapa corrente.
		assertTrue(obterAtributoDoElemento(etapaCorrente, "class").contains("first"));
		
		int qtdItensDistintosCarrinho = buscarElementos(linhasTabelaResumoCarrinho).size();
		assertEquals(cli.getCarrinhoItens().size(), qtdItensDistintosCarrinho);
		
		clicar(botaoProsseguirEtapaResumoCarrinho);
	}

	public void cadastrarCliente(Cliente cli)
	{
		// Tela de Pré-Cadastro e Login.
		escrever(campoEmailPreCadastro, cli.getEmail());
		clicar(botaoCadastrarCliente);
		
		// Valida etapa corrente.
		assertTrue(obterAtributoDoElemento(etapaCorrente, "class").contains("second"));
		
		// Preenchimento do Formulário de Cadastro.
		selecionarTipoTratamento(cli.getTipoTratamento());
		preencherPrimeiroNome(cli.getPrimeiroNome());
		preencherUltimoNome(cli.getUltimoNome());
		preencherSenha(cli.getSenha());
		preencherEnderecoPrincipal(cli.getEndereco().getEnderecoPrincipal());
		preencherCidade(cli.getEndereco().getCidade());
		selecionarEstado(cli.getEndereco().getEstado());
		preencherCodigoPostal(cli.getEndereco().getCodigoPostal());
		selecionarPais(cli.getEndereco().getPais());
		preencherFoneCelular(cli.getContato().getFoneCelular());
		preencherIdentificadorEndereco(cli.getEndereco().getIdentificadorEndereco());
		
		if (cli.getAssinarNewsletter() == TipoSimNao.SIM) {
			clicar(checkboxAssinarNewsletter);
		}
		
		if (cli.getReceberOfertasDeParceiros() == TipoSimNao.SIM) {
			clicar(checkboxReceberOfertasDeParceiros);
		}
		
		// Validação dos Campos Autopreenchidos.
		assertEquals(cli.getEmail(), obterAtributoDoElemento(campoEmail, "value"));
		assertEquals(cli.getPrimeiroNome(), obterAtributoDoElemento(campoPrimeiroNomeDestinatario, "value"));
		assertEquals(cli.getUltimoNome(), obterAtributoDoElemento(campoUltimoNomeDestinatario, "value"));

		clicar(botaoProsseguirEtapaCadastroCliente);
	}

	public void validarEnderecoEntrega(Cliente cli)
	{
		assertTrue(obterAtributoDoElemento(etapaCorrente, "class").contains("third"));

		// Alias para facilitar leitura e entendimento do código.
		Endereco end = cli.getEndereco();
		Contato con = cli.getContato();

		String nomeSobrenomeCliente = cli.getPrimeiroNome() + " " + cli.getUltimoNome();
		String cidadeEstadoPais = end.getCidade() + ", " + end.getEstado() + " " + end.getCodigoPostal();

		// Validações do endereço de entrega.
		assertEquals(nomeSobrenomeCliente, obterTexto(textoNomeSobrenomeDestinatario));
		assertEquals(end.getEnderecoPrincipal(), obterTexto(textoEnderecoDestinatario));
		assertEquals(cidadeEstadoPais, obterTexto(textoCidadeEstadoCodPostalDestinatario));
		assertEquals(end.getPais(), obterTexto(textoPaisDestinatario));
		assertEquals(con.getFoneCelular(), obterTexto(textoFoneCelularDestinatario));

		clicar(botaoProsseguirEtapaConfirmacaoDestinatario);
	}

	public void aceitarTermosCompromisso()
	{
		assertTrue(obterAtributoDoElemento(etapaCorrente, "class").contains("four"));
		clicar(checkboxTermosDeServico);
		clicar(botaoProsseguirEtapaFormaEntrega);
	}

	public void escolherFormaDePagamento(Cliente cli)
	{
		assertTrue(obterAtributoDoElemento(etapaCorrente, "class").contains("last"));
		
		Float valorTotalProduto = obterValorDecimal(obterTexto(textoValorTotalProduto));
		Float valorFrete = obterValorDecimal(obterTexto(textoValorFrete));
		String valorFinal = obterTexto(textoValorFinal);		
		
		assertEquals(Utils.adicionarMascaraMoedaDolar(valorTotalProduto+valorFrete), valorFinal);

		if (cli.getTipoPagamento() == TipoPagamento.TRANSF_BANCARIA) {
			clicar(botaoTipoPagamentoTransferenciaBancaria);	
		} else if (cli.getTipoPagamento() == TipoPagamento.CHEQUE) {
			clicar(botaoTipoPagamentoCheque);
		}
		
		clicar(botaoConfirmarOrdemDeCompra);
	}

	public void validarPedidoDeCompra(Cliente cli)
	{
		assertTrue(obterAtributoDoElemento(etapaCorrente, "class").contains("last"));
		assertEquals(Mensagens.msgYourOrderIsComplete(), obterTexto(mensagemProcessoCompraCompletada));
		
		String textoPosOrdemCompra = obterTexto(textoInformativoPosOrdemDeCompra);
		String referenciaCodigo = "your order reference ";
		Integer indiceInicial = textoPosOrdemCompra.indexOf(referenciaCodigo) + referenciaCodigo.length();
		String codOrdemPedido = textoPosOrdemCompra.substring(indiceInicial, indiceInicial+9);
		
		clicar(botaoVisualizarMinhaConta);
		clicar(botaoHistoricoPedidos);
		
		String codOrdemPedidoExibido = obterTexto(textoCodigoOrdemPedido);
		assertEquals(codOrdemPedido, codOrdemPedidoExibido);
		
		clicar(botaoExibirHistoricoProduto);
		executarJS("arguments[0].scrollIntoView();", buscarElemento(tabelaDadosProduto));
		
		String infoProduto = obterTexto(textoInfoProduto);
		String qtdProduto = obterTexto(textoQtdProduto);
		String valorUnitarioProduto = obterTexto(textoValorUnitarioProduto);
		String valorSemFreteExibido = obterTexto(textoValorSemFreteProduto);
		String valorFrete = obterTexto(textoValorFreteProduto);
		String valorComFreteExibido = obterTexto(textoValorComFreteProduto);
		
		Produto produtoComprado = cli.getCarrinhoItens().get(0);
		assertTrue(infoProduto.contains(produtoComprado.getTitulo()));
		assertTrue(infoProduto.contains(produtoComprado.getCor()));
		assertTrue(infoProduto.contains(produtoComprado.getTamanho()));
		assertTrue(qtdProduto.contains(Integer.toString(produtoComprado.getQuantidade())));
		assertTrue(valorUnitarioProduto.contains(produtoComprado.getPreco()));
		
		String valorSemFreteEsperado = obterValorTotalItensSemFrete(produtoComprado.getPreco(), produtoComprado.getQuantidade());
		assertEquals(valorSemFreteEsperado, valorSemFreteExibido);
		
		Float valorComFreteEsperado = obterValorDecimal(valorSemFreteExibido) + obterValorDecimal(valorFrete);
		assertEquals(Utils.adicionarMascaraMoedaDolar(valorComFreteEsperado), valorComFreteExibido);
	}

	private void selecionarTipoTratamento(TipoTratamento tipoTratamento)
	{
		if (tipoTratamento == TipoTratamento.MR) {
			clicar(radioTipoTratamentoMr);
		} else {
			clicar(radioTipoTratamentoMra);
		}
	}

	private void preencherPrimeiroNome(String primeiroNome)
	{
		escrever(campoPrimeiroNome, primeiroNome);
	}

	private void preencherUltimoNome(String ultimoNome)
	{
		escrever(campoUltimoNome, ultimoNome);
	}

	private void preencherSenha(String senha)
	{
		escrever(campoSenha, senha);
	}

	private void preencherEnderecoPrincipal(String enderecoPrincipal)
	{
		escrever(campoEndereco, enderecoPrincipal);
	}

	private void preencherCidade(String cidade)
	{
		escrever(campoCidade, cidade);
	}

	private void selecionarEstado(String estado)
	{
		selecionarCombo(comboEstado, estado);
	}

	private void preencherCodigoPostal(String codigoPostal)
	{
		escrever(campoCodigoPostal, codigoPostal);
	}

	private void selecionarPais(String pais)
	{
		selecionarCombo(comboPais, pais);
	}

	private void preencherFoneCelular(String foneCelular)
	{
		escrever(campoFoneCelular, foneCelular);
	}

	private void preencherIdentificadorEndereco(String enderecoReferencia)
	{
		escrever(campoIdentificadorEndereco, enderecoReferencia);
	}
	
	private String obterValorTotalItensSemFrete(String valor, Integer quantidade) {
		return Utils.adicionarMascaraMoedaDolar(quantidade * obterValorDecimal(valor));
	}
	
	private Float obterValorDecimal(String valor) {
		return Float.parseFloat(valor.substring(1));
	}

}
