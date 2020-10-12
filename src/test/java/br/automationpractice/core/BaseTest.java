package br.automationpractice.core;

import static br.automationpractice.core.DriverFactory.getDriver;
import static br.automationpractice.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Pré-condições e pós-Condições dos testes.
 * 
 * @author Giovanni D. Brancher
 */
public class BaseTest {

	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializa() {
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get("http://www.automationpractice.com/");
	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		String timeStamp = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		String caminhoEvidenciaGerada = "target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + timeStamp  + ".jpg";
		FileUtils.copyFile(arquivo, new File(caminhoEvidenciaGerada));
		killDriver();
	}
	
}