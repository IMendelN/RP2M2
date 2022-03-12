package RF_8;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Ferramentas.LeitorCsv;
import Ferramentas.OperacoesDriver;
import elementos.InProjeto;
import elementos.ProjScoStat;

public class RF_8_code{

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
	nav.abreScopeStatement();
	}

	@Test
	public void fluxoPrincipal() throws InterruptedException {
	nav.editaScopeStatement("Teste", "Teste", "Teste", "Teste");
	nav.click(ProjScoStat.Save);
	assertEquals(nav.getUrl(), ProjScoStat.URL);
	}
	
	@Test
	public void FluxoExcecao() throws InterruptedException {
		String f = "";
		for(int i = 0; i > 2050; i ++) f += "f";
	nav.editaScopeStatement("", "187a", f, ",#fad");
	nav.click(ProjScoStat.Save);
	Thread.sleep(5000);
	assertEquals(ProjScoStat.URL + "?", nav.getUrl());
	}

	@Test
	public void fluxoExecao1() throws InterruptedException {
		nav.click(ProjScoStat.Back);
		Thread.sleep(5000);
		assertEquals(nav.getUrl(), InProjeto.URL + "?");
	}


	@After
	public void after() throws InterruptedException {
		Thread.sleep(500);
		nav.getDriver().close();
	}
}
