package RF_22_6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Ferramentas.LeitorCsv;
import Ferramentas.OperacoesDriver;
import elementos.InProjeto;
import elementos.Login;
import elementos.SheduleDurationEstimates;
import elementos.SheduleEarnedValueManagement;

public class RF_22_6_Dionas{

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
		nav.click(InProjeto.SheEarValManag);
	}

	@Test
	public void fluxoPrincipal() throws InterruptedException {
		//valores corretos:
		nav.scheduleEarnedValueManagement_Edit("340.48", "584.18", "4652", "18", "3446", "80", "18.18", "1401", "12");
		Thread.sleep(1000);
		assertEquals(SheduleEarnedValueManagement.URL, nav.getUrl());
	}

	@Test
	public void fluxoExecao1() throws InterruptedException {
		//valores negativos, maiores que 10000 e com 3 numeros após a virgula:
		nav.scheduleEarnedValueManagement_Edit("340.486", "54584.18", "-4652", "80000", "-3446", "80562", "-18.18", "14501", "-12");
		Thread.sleep(1000);
		assertEquals(SheduleEarnedValueManagement.EditURL, nav.getUrl());
		nav.click(SheduleEarnedValueManagement.EditBack);
		assertEquals(SheduleEarnedValueManagement.URL + "?", nav.getUrl());
	}
	
	@Test
	public void fluxoExecao2() throws InterruptedException {
		//não envia valores:
		nav.scheduleEarnedValueManagement_Edit("", "", "", "", "", "", "", "", "");
		Thread.sleep(1000);
		assertEquals(SheduleEarnedValueManagement.URL, nav.getUrl());
	}

	@After
	public void after() throws InterruptedException {
		Thread.sleep(500);
		nav.getDriver().close();
	}
}
