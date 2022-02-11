package testesRF22_2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Ferramentas.Driver;
import Ferramentas.LeitorCsv;
import elementos.*;

public class TesteRF22_2 {

	public static LeitorCsv leitorResultados;
	public static LeitorCsv leitorComandos;
	public String resultados[];
	public String comandos[];
	public static Driver nav;

	@BeforeClass
	public static final void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
	}

	@Before
	public final void setBefore() throws Exception {
		nav = new Driver();
	}

	@Test
	public void fluxoPrincipal() throws InterruptedException {
		nav.get(Login.URL);
		nav.fazLogin();
		Thread.sleep(1000);
		nav.getDriver().manage().window().maximize();
		nav.click(InicioProjeto.AbrirProjeto1);
		Thread.sleep(500);
		nav.click(InProjeto.SheNetDiag);

		nav.click(SheduleNetworkDiagram.Edit);

		nav.click(SheduleNetworkDiagram.EditTxt1);
		nav.limpaTexto(SheduleNetworkDiagram.EditTxt1);
		nav.sendKeys("Teste´´", SheduleNetworkDiagram.EditTxt1);

		nav.click(SheduleNetworkDiagram.EditTxt2);
		nav.limpaTexto(SheduleNetworkDiagram.EditTxt2);
		nav.sendKeys("Teste]][[", SheduleNetworkDiagram.EditTxt2);

		nav.click(SheduleNetworkDiagram.EditTxt3);
		nav.limpaTexto(SheduleNetworkDiagram.EditTxt3);
		nav.sendKeys("Teste", SheduleNetworkDiagram.EditTxt3);

		nav.click(SheduleNetworkDiagram.EditTxt4);
		nav.limpaTexto(SheduleNetworkDiagram.EditTxt4);
		nav.sendKeys("Teste123456", SheduleNetworkDiagram.EditTxt4);

		Thread.sleep(500);
		nav.click(SheduleNetworkDiagram.EditSubmit);
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/project-schedule-network-diagram/list/84",
				nav.getUrl());
	}

	@Test
	public void FluxoAlternativo1() throws InterruptedException {
		nav.get(Login.URL);
		nav.fazLogin();
		nav.getDriver().manage().window().maximize();
		Thread.sleep(1000);
		nav.click(InicioProjeto.AbrirProjeto1);
		Thread.sleep(5000);
		nav.click(InProjeto.SheNetDiag);
		nav.click(SheduleNetworkDiagram.Upload);
		Thread.sleep(1000);
		nav.sendKeys("teste", SheduleNetworkDiagram.UploadName);
		nav.sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\ImagemTestes.png", SheduleNetworkDiagram.UploadArquivo);
		nav.click(SheduleNetworkDiagram.UploadSave);
		Thread.sleep(1000);
		nav.click(SheduleNetworkDiagram.ExcluiImagem);
	}

	@After
	public void after() throws InterruptedException {
		Thread.sleep(500);
		nav.getDriver().close();
	}
}
