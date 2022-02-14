package Adriel;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActivityList {
	
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
			dsl.close();;
		}
		
		@Test
		public void fluxoPrincipal() throws InterruptedException {
		
			page.inicia();
			
			page.setEmail("adrielluan.aluno@unipampa.edu.br");
			
			page.setSenha("1040.shiriuuu");
			
	        page.entrar();
			
	        page.openProject();

	        page.acitivityList();
	
	        page.listNew();
 
	        page.activityLabel("test1");

	        page.milestone("test2");
	        
	        page.activityName("test3");
	        
	        page.projectPashe("test4");
	        
	        page.WBSid("test4"); 
	        
	        page.activityDesc("test5");
	        
	        page.activitySave();

        
        
        
	}
}