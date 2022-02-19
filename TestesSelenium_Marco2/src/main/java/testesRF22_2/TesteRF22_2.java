package testesRF22_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Ferramentas.LeitorCsv;
import Ferramentas.OperacoesDriver;
import elementos.Login;
import elementos.SheduleNetworkDiagram;

public class TesteRF22_2 {

	public static LeitorCsv leitorResultados;
	public static LeitorCsv leitorComandos;
	public String resultados[];
	public String comandos[];
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
		nav.abreScheduleNetworkDiagram();
	}

	@Test
	public void fluxoPrincipal() throws InterruptedException {

		nav.scheduleNetworkDiagram_Edit("Teste", "Teste", "Teste[]", "Teste123");
	
		assertEquals("Teste",nav.getText(SheduleNetworkDiagram.TextActivityName0));
		assertEquals("Teste",nav.getText(SheduleNetworkDiagram.TextProcessorActivity1));
		assertEquals("Teste",nav.getText(SheduleNetworkDiagram.TextDepencdenceType2));
		assertEquals("Teste[]",nav.getText(SheduleNetworkDiagram.TextAntecipation3));
		assertEquals("Teste123",nav.getText(SheduleNetworkDiagram.TextWait4));
	}

	@Test
	public void FluxoAlternativo1() throws InterruptedException {
		Thread.sleep(1000);
		nav.scheduleNetworkDiagram_Upload("Teste", System.getProperty("user.dir") + "\\src\\main\\resources\\ImagemTestes.png");
		Thread.sleep(1000);
		assertNotNull(nav.getText(SheduleNetworkDiagram.NameImage1));
		nav.scheduleNetworkDiagram_ExcluiImagem();
	}
	
	@Test
	public void FluxoExcecao() throws InterruptedException {
		nav.scheduleNetworkDiagram_EditExcecao();
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/project-schedule-network-diagram/edit/533", nav.getUrl());
		nav.click(SheduleNetworkDiagram.EditBack);
		Thread.sleep(1000);
		
		nav.scheduleNetworkDiagram_UploadExcecao();
		nav.click(SheduleNetworkDiagram.UploadClose);
		
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/project-schedule-network-diagram/list/84?", nav.getUrl());
		Thread.sleep(1000);

	}

	@After
	public void after() throws InterruptedException {
		Thread.sleep(500);
		nav.getDriver().close();
	}
}
