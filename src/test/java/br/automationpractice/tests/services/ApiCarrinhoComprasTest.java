package br.automationpractice.tests.services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

/**
 * Classe de testes da API do Carrinho de Compras.
 * 
 * @author Giovanni D. Brancher
 */
public class ApiCarrinhoComprasTest {

	/**
	 * Deve verificar e validar o response da requisição realizada.
	 */
	@Test
	public void deveValidarValoresResponse() {
		given()
		.when()
			.get("http://5d9cc58566d00400145c9ed4.mockapi.io/shopping_cart")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("shopping_cart", is(1))
			.body("sku", hasSize(3))
			.body("sku", hasItems("demo_2", "demo_1", "demo_7"))
			.body("color", hasSize(3))
			.body("color", hasItems("Black", "Orange", "Yellow"))
			.body("size", hasSize(3))
			.body("size", hasItems("S", "S", "S"))
			.body("price", hasSize(3))
			.body("price", hasItems("27.00", "16.51", "16.40"))
			.body("total_shipping", is("2.00"));
		;
	}
	
	/**
	 * Deve validar o schema do response.
	 */
	@Test
	public void deveValidarSchemaResponse() {
		given()
		.when()
			.get("http://5d9cc58566d00400145c9ed4.mockapi.io/shopping_cart")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemaApiCarrinhoCompras.json"))
		;
	}
}
