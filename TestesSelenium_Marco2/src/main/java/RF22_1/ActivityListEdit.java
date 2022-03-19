package RF22_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Adriel.DSL;
import Adriel.SilverBulletPage;

public class ActivityListEdit {
	
	public static WebDriver driver;
	private DSL dsl;
	private SilverBulletPage page;
	
	@Before
	public final void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(1500,1500));
		dsl = new DSL(driver);
		page = new SilverBulletPage(driver);
		
		}
	
		@After
		public void Finalizar() {
			dsl.close();
		}
		@Test
		public void testPrincipal() throws InterruptedException {
			
			page.inicia();
			
			page.setEmail("adrielluan.aluno@unipampa.edu.br");
			
			page.setSenha("1040.shiriuuu");
			
	        page.entrar();
			
	        page.openProject();

	        page.acitivityList();
	        
	        page.activityEdit();
		
}
}
