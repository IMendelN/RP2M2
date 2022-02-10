package Adriel;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Resource {

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
		dsl.close();;
	}
	
	@Test
	public void FluxoPrincipal()   { 
		
		
		dsl.get("http://www.lesse.com.br/tools/silverbullet/rp2");
		dsl.escreveID("email", "adrielluan.aluno@unipampa.edu.br");
		assertEquals("adrielluan.aluno@unipampa.edu.br",dsl.obterValorCampo("email"));
		dsl.escreveID("password","1040.shiriuuu");
		assertEquals("1040.shiriuuu",dsl.obterValorCampo("password"));
        dsl.clicaRadio("login-submit");
        
        
        dsl.clicaXpath("//td[3]/a/span");
		dsl.clicaXpath("//div[4]/div/div[3]/a[2]/div/div");
		dsl.clicaXpath("//div/div/form/button");
		
		dsl.limpaCampo("resource_description");
		dsl.escreveID("resource_description", "teste2");
		assertEquals("teste2", dsl.obterValorCampo("resource_description"));
		
		dsl.limpaCampo("required_amount_of_resource");
		dsl.escreveID("required_amount_of_resource", "1");
		assertEquals("1", dsl.obterValorCampo("required_amount_of_resource"));
		
		dsl.limpaCampo("resource_cost_per_unit");
		dsl.escreveID("resource_cost_per_unit", "0.01");
		assertEquals("0.01", dsl.obterValorCampo("resource_cost_per_unit"));
		
		dsl.limpaCampoCss("#rr_txt_4");
		dsl.escreveCss("#rr_txt_4", "test");
		assertEquals("test", dsl.obterValorCampoCss("#rr_txt_4"));
		
		dsl.clicaRadioCss("#activity-submit");
				
	}	
}