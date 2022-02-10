package Adriel;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResourceRequirements {

	private DSL dsl;
	
	@Before
	public final void setUp() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(900, 900));
		dsl = new DSL(driver);

	}
	
	@After 
	public void Finalizar() {
		dsl.close();
	}
	
	@Test
	public void fluxoAlternativo() throws InterruptedException {
		
	dsl.get("http://www.lesse.com.br/tools/silverbullet/rp2");
	dsl.escreveID("email", "adrielluan.aluno@unipampa.edu.br");
	assertEquals("adrielluan.aluno@unipampa.edu.br",dsl.obterValorCampo("email"));
	dsl.escreveID("password","1040.shiriuuu");
	assertEquals("1040.shiriuuu",dsl.obterValorCampo("password"));
    dsl.clicaRadio("login-submit");
     
    
    dsl.clicaXpath("//td[3]/a/span");
	dsl.clicaXpath("//div[4]/div/div[3]/a[2]/div/div");	
	dsl.clicaRadioCss(".col-lg-12 > .btn-info");
	Thread.sleep(500);
	
	dsl.escreveCss(".row:nth-child(1) > .col-lg-6 .form-control", "teste");
	dsl.escreveCss(".col-lg-12 > .form-group > input", "C:\\Users\\adrie\\OneDrive\\Área de Trabalho\\RP ll\\Nova pasta\\csv.png");
	dsl.clicaRadioCss(".btn-success:nth-child(1)");
	assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/resource-requirements/list/73", dsl.UrlCorreta());
	
  
	
	}
}