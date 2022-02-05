package TesteLogin;
import static org.junit.Assert.*;

import java.io.FileReader;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;

public class TesteLogin {
	public static WebDriver driver;
	public static CSVReader leitor;
	public static String resultados[];
	
	
	@BeforeClass
	public static final void setUp() throws Exception {
		leitor = new CSVReader(new FileReader(".\\src\\main\\java\\TesteLogin\\Resultados.csv"));
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
	}
	
	@Before
	public final void setBefore() throws Exception {
		String cell[];
		if((cell = leitor.readNext()) != null) {
			for(String dadosCSV : cell){
				resultados = dadosCSV.split("; ");
			}
		}
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(675, 450));
	}

	@Test
	public void testFluxoPrincipal() throws InterruptedException {
		driver.get("http://www.lesse.com.br/tools/silverbullet/rp2");
		Thread.sleep(500);
		driver.findElement(By.id("email")).sendKeys("dionasmuller.aluno@unipampa.edu.br");
		driver.findElement(By.id("password")).sendKeys("senhaTeste");
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(500);
		assertEquals(resultados[0], driver.getCurrentUrl());
	}
	
	//O teste esta Apresentando A MSG5 e nao a MSG2 como previsto;
	@Test
	public void testFluxoAlternativo1() throws InterruptedException {
		driver.get("http://www.lesse.com.br/tools/silverbullet/rp2");
		Thread.sleep(500);
	    driver.findElement(By.id("login-submit")).click();
	    driver.findElement(By.id("login-submit")).click();
	    Thread.sleep(500);
	    assertEquals(resultados[0], driver.getCurrentUrl());
	    assertEquals(resultados[1],driver.getTitle());
	    assertEquals(resultados[2],driver.findElement(By.cssSelector("strong:nth-child(6) > .flashMsg")).getText());
	}
	
	@Test
	public void testFluxoAlternativo2() throws InterruptedException {
		driver.get("http://www.lesse.com.br/tools/silverbullet/rp2");
		Thread.sleep(500);
		driver.findElement(By.id("email")).sendKeys("dionasmuller.aluno@unipampa.edu.br");
		driver.findElement(By.id("password")).sendKeys("senha");
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(500);
		driver.findElement(By.id("email")).sendKeys("dionasmuller.aluno@unipampa.edu.br");
		driver.findElement(By.id("password")).sendKeys("senha");
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(500);
		assertEquals(resultados[0], driver.getCurrentUrl());
		assertEquals(resultados[1],driver.getTitle());
	    assertEquals(resultados[2],driver.findElement(By.cssSelector("strong:nth-child(6) > .flashMsg")).getText());
	}
	
	
	@After
	  public final void after() throws InterruptedException {
		 Thread.sleep(500);
		 driver.close();
	 }
	
	 @AfterClass
	  public static final void afterClass() throws InterruptedException {
		 Thread.sleep(500);
		 driver.quit();
	 }

}
