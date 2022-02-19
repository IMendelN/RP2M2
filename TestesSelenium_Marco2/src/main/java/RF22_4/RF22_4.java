package RF22_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		fail("Não foi posível realizar o teste pois o \"Duration Estimates\""
				+ " não estava previamente criado (Conforme Orientava o fluxo principal" 
				+ "do testes no git hub), para testar estas funções foi"
				+ " desenvolvido o fluxoPrincipalCriar que tenta criá-lo" 
				+ " (embora não consiga devido à outro erro do sisema)");
	}

	@Test
	public void fluxoPrincipalCriar() throws InterruptedException {
		nav.scheduleDurationEstimates_criarNovo("100","2022-03-10", "2023-03-05", "85", "2022-03-10", "2023-03-05");
		
		assertEquals(SheduleDurationEstimates.URL, nav.getUrl());
	}
	
	@Test
	public void fluxoExecao1() throws InterruptedException {
	nav.click(SheduleDurationEstimates.novo);
	nav.click(SheduleDurationEstimates.novoSubmit);
	assertEquals(SheduleDurationEstimates.novoURL,nav.getUrl());
	Thread.sleep(1000);
	nav.click(SheduleDurationEstimates.novoNome);
	Thread.sleep(1000);
	nav.click(SheduleDurationEstimates.novoNomeSelect1);
	nav.click(SheduleDurationEstimates.novoSubmit);
	assertEquals(SheduleDurationEstimates.novoURL, nav.getUrl());
	}
	

	@Test
	public void fluxoAlternativo() throws InterruptedException {
		nav.click(SheduleDurationEstimates.upload);
		Thread.sleep(1000);
		nav.click(SheduleDurationEstimates.uploadNome);
		nav.sendKeys("TESTER22_4Alt", SheduleDurationEstimates.uploadNome);
		nav.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\ImagemTestes.png", SheduleDurationEstimates.uploadArquivo);
		nav.click(SheduleDurationEstimates.salvaUpload);
		Thread.sleep(1000);
		nav.click(SheduleDurationEstimates.excluiUpload);
		Thread.sleep(1000);

	}

	@After
	public void after() throws InterruptedException {
		Thread.sleep(500);
		nav.getDriver().close();
	}
}
