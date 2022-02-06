package TesteLogin;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Ferramentas.Driver;
import Ferramentas.LeitorCsv;

public class TesteLogin {
	public static LeitorCsv leitorResultados;
	public static LeitorCsv leitorComandos;
	public String resultados[];
	public String comandos[];
	public Driver nav;
	
	
	@BeforeClass
	public static final void setUp() throws Exception {
		leitorResultados = new LeitorCsv(".\\src\\main\\java\\TesteLogin\\Resultados.csv");
		leitorComandos = new LeitorCsv(".\\src\\main\\java\\TesteLogin\\Comandos.csv");
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
	}
	
	@Before
	public final void setBefore() throws Exception {
		nav = new Driver();
		comandos = leitorComandos.lerProximaLinhaSeparando("; ");
		resultados = leitorResultados.lerProximaLinhaSeparando("; ");
	}

	@Test
	public void testFluxoPrincipal() throws InterruptedException {
		nav.get(comandos[0]);
		Thread.sleep(500);
		nav.sendKeysCsv(comandos[1]);
		nav.sendKeysCsv(comandos[2]);
		nav.clickCsv(comandos[3]);
		Thread.sleep(500);
		assertEquals(resultados[0], nav.getUrl());
	}
	
	//O teste esta Apresentando A MSG5 e nao a MSG2 como previsto;
	@Test
	public void testFluxoAlternativo1() throws InterruptedException {
		nav.get(comandos[0]);
		Thread.sleep(500);
		nav.clickCsv(comandos[1]);
		nav.clickCsv(comandos[1]);
	    Thread.sleep(500);
	    assertEquals(resultados[0], nav.getUrl());
	    assertEquals(resultados[1], nav.getTitle());
	    assertEquals(resultados[2], nav.getTextCsv(comandos[2]));
	}
	
	@Test 
	public void testFluxoAlternativo2() throws InterruptedException {
		nav.get(comandos[0]);
		Thread.sleep(500);
		for(int i = 0; i < 2; i++) {
		nav.sendKeysCsv(comandos[1]);
		nav.sendKeysCsv(comandos[2]);
		nav.clickCsv(comandos[3]);
		Thread.sleep(500);
		}
		assertEquals(resultados[0], nav.getUrl());
		assertEquals(resultados[1], nav.getTitle());
	    assertEquals(resultados[2], nav.getTextCsv(comandos[4]));
	}
	
	
	@After
	  public final void after() throws InterruptedException {
		 Thread.sleep(500);
		 nav.getDriver().quit();
	 }
	
	 @AfterClass
	  public static final void afterClass() throws InterruptedException {
		 Thread.sleep(500);
		 }

}
