package br.automationpractice.core;

import static br.automationpractice.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Métodos base para execução dos testes.
 * 
 * @author Giovanni D. Brancher
 */
public class BasePage {
	
	protected WebDriverWait wait = new WebDriverWait(getDriver(), 15);
	
	public void escrever(By by, String texto) {
		destacarElemento(by);
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escrever(By by, Integer numero) {
		escrever(by, Integer.toString(numero));
	}
	
	public void clicar(By by) {
		destacarElemento(by);
		getDriver().findElement(by).click();
	}

	public String obterTexto(By by) {
		destacarElemento(by);
		return getDriver().findElement(by).getText();
	}
	
	public String obterAtributoDoElemento(By by, String atributo) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return getDriver().findElement(by).getAttribute(atributo);
	}
	
	public void selecionarCombo(By by, String opcao) {
		Select combo = new Select(getDriver().findElement(by));
		combo.selectByVisibleText(opcao);
	}
	
	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	public WebElement buscarElemento(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return getDriver().findElement(by);
	}
	
	public List<WebElement> buscarElementos(By by) {
		return getDriver().findElements(by);
	}
	
	private void destacarElemento(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", getDriver().findElement(by), "border: 4px solid green;");
	}
}
