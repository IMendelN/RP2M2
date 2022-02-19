package RF22_4;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import Ferramentas.LeitorCsv;
import Ferramentas.OperacoesDriver;
import elementos.Login;
import elementos.SheduleDurationEstimates;

public class RF22_4 {

	public static LeitorCsv leitorResultados;
	public static LeitorCsv leitorComandos;
	public static OperacoesDriver nav;

	@BeforeClass
	public static final void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
	}

	@Before
	public final void setBefore() throws Exception {
		nav = new OperacoesDriver();
		nav.get(Login.URL);
		nav.fazLogin("dionasmuller.aluno@unipampa.edu.br", "senhaTeste");
		Thread.sleep(1000);
		nav.getDriver().manage().window().maximize();
		nav.abreProjeto1();
		Thread.sleep(500);
		nav.abreScheduleDurationEstimates();
	}

	@Test
	public void fluxoPrincipal() throws InterruptedException {
		Thread.sleep(10000);
		nav.click(SheduleDurationEstimates.novo);
		Thread.sleep(1000);
		nav.click("activity_id", "name");
		Thread.sleep(1000);
		nav.click("//form/ul/div[1]/select/option[2]", "xpath");
		Thread.sleep(1000);
		nav.sendKeys("100", "estimated_duration", "id");
		nav.sendKeys("2022-03-10", "estimated_start_date", "id");
		nav.sendKeys("2023-03-05", "estimated_end_date", "id");
		nav.sendKeys("85", "performed_duration", "id");
		nav.sendKeys("2022-03-10", "performed_start_date", "id");
		nav.sendKeys("2023-03-05", "performed_end_date", "id");
		nav.click("activity-submit", "id");
		Thread.sleep(10000);
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/duration-estimates/list/84?",
				nav.getUrl());
	}

	@Test
	public void fluxoAlternativo() throws InterruptedException {
		nav.click("//div/div/div/div/div/button[2]", "xpath");
		Thread.sleep(1000);
		nav.click("//div[2]/div/div[2]/form/div/div/div/input", "xpath");
		nav.sendKeys("TESTER22_4Alt", "//div[2]/div/div[2]/form/div/div/div/input", "xpath");
		nav.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\ImagemTestes.png", "//div[2]/div/div/input", "xpath");
		nav.click("//div[3]/div/div/button", "xpath");
		Thread.sleep(1000);
		nav.click("//em", "xpath");
		Thread.sleep(1000);

	}

	@After
	public void after() throws InterruptedException {
		Thread.sleep(500);
		nav.getDriver().close();
	}
}
