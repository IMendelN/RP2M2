package RF22_7;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Ferramentas.LeitorCsv;
import Ferramentas.OperacoesDriver;
import elementos.Login;
import elementos.ScheduleProjectCalendar;

public class ProjectCalendar {
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
		nav.fazLogin("iagonogueira.aluno@unipampa.edu.br", "testesenha");
		Thread.sleep(1000);
		nav.getDriver().manage().window().maximize();
		nav.abreProjeto1();
		Thread.sleep(500);
		nav.abreScheduleProjectCalendar();
	}
	
	@Test
	public void fluxoPrincipal() throws InterruptedException {
		nav.get("http://www.lesse.com.br/tools/silverbullet/rp2/project/68");
	    nav.click(ScheduleProjectCalendar.PCURL);
	    Thread.sleep(500);
	    nav.click(ScheduleProjectCalendar.edit);
	    Thread.sleep(500);
	    nav.click(ScheduleProjectCalendar.save);
	    
	}
	@After
	public void close() throws InterruptedException {
		Thread.sleep(500);
		nav.getDriver().close();
	}

	
}
