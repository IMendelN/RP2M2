package RF22_7;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
		nav.fazLogin("marcoseduardo.aluno@unipampa.edu.br", "senhateste123");
		Thread.sleep(1000);
		nav.getDriver().manage().window().maximize();
		nav.abreProjeto1();
		Thread.sleep(500);
		nav.abreScheduleProjectCalendar();
	}

	@Test
	public void fluxoPrincipal() throws InterruptedException {
		nav.get("http://www.lesse.com.br/tools/silverbullet/rp2/project/72");
		nav.click(ScheduleProjectCalendar.PCURL);
		Thread.sleep(2000);
		nav.click(ScheduleProjectCalendar.edit);
		Thread.sleep(2000);
		nav.click(ScheduleProjectCalendar.ActivityName);
		nav.click(ScheduleProjectCalendar.StakeHolder);
		nav.limpaTexto(ScheduleProjectCalendar.Function);
		nav.sendKeys("teste", ScheduleProjectCalendar.Function);
		nav.limpaTexto(ScheduleProjectCalendar.AvailabilityStart);
		nav.sendKeys("2022-03-07", ScheduleProjectCalendar.AvailabilityStart);
		nav.limpaTexto(ScheduleProjectCalendar.AvailabilityEnds);
		nav.sendKeys("2022-03-08", ScheduleProjectCalendar.AvailabilityEnds);
		nav.limpaTexto(ScheduleProjectCalendar.AllocationStart);
		nav.sendKeys("2022-03-07", ScheduleProjectCalendar.AllocationStart);
		nav.limpaTexto(ScheduleProjectCalendar.AllocationEnds);
		nav.sendKeys("2022-03-08", ScheduleProjectCalendar.AllocationEnds);
		nav.click(ScheduleProjectCalendar.save);
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/project-calendars/list/72", nav.getUrl());
	}

	@Test
	public void fluxoExcecao() throws InterruptedException {
		nav.get("http://www.lesse.com.br/tools/silverbullet/rp2/project/72");
		nav.click(ScheduleProjectCalendar.PCURL);
		Thread.sleep(2000);
		nav.click(ScheduleProjectCalendar.edit);
		Thread.sleep(2000);
		nav.click(ScheduleProjectCalendar.ActivityName);
		nav.click(ScheduleProjectCalendar.StakeHolder);
		nav.limpaTexto(ScheduleProjectCalendar.Function);
		nav.sendKeys("", ScheduleProjectCalendar.Function);
		nav.limpaTexto(ScheduleProjectCalendar.AvailabilityStart);
		nav.sendKeys("", ScheduleProjectCalendar.AvailabilityStart);
		nav.limpaTexto(ScheduleProjectCalendar.AvailabilityEnds);
		nav.sendKeys("", ScheduleProjectCalendar.AvailabilityEnds);
		nav.limpaTexto(ScheduleProjectCalendar.AllocationStart);
		nav.sendKeys("", ScheduleProjectCalendar.AllocationStart);
		nav.limpaTexto(ScheduleProjectCalendar.AllocationEnds);
		nav.sendKeys("", ScheduleProjectCalendar.AllocationEnds);
		Thread.sleep(5000);
		nav.click(ScheduleProjectCalendar.save);
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/project-calendars/edit/524", nav.getUrl());
	}
	
	@Test
	public void fluxoAlternativo() throws InterruptedException {
		nav.get("http://www.lesse.com.br/tools/silverbullet/rp2/project/72");
	    nav.click(ScheduleProjectCalendar.PCURL);
	    Thread.sleep(500);
	    nav.click(ScheduleProjectCalendar.upload);
	    Thread.sleep(500);
	    nav.click(ScheduleProjectCalendar.uploadName);
	    nav.sendKeys("TesteImage1", ScheduleProjectCalendar.uploadName);
	    Thread.sleep(1000);
	    nav.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\ImagemTestes.png", ScheduleProjectCalendar.uploadImage);
	    nav.click(ScheduleProjectCalendar.uploadSave);
	    assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/project-calendars/list/72?", nav.getUrl());
	    Thread.sleep(1000);
	    
	}

	@After
	public void close() throws InterruptedException {
		Thread.sleep(500);
		nav.getDriver().close();
	}

}
