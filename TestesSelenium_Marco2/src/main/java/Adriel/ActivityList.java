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
			assertEquals("adrielluan.aluno@unipampa.edu.br",dsl.obterValorCampo("email"));
			
			page.setSenha("1040.shiriuuu");
			assertEquals("1040.shiriuuu",dsl.obterValorCampo("password"));
			
	        page.entrar();
	        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/projects", dsl.UrlCorreta());
			
	        page.openProject();
	        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/project/73", dsl.UrlCorreta());

	        page.acitivityList();
	        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/activity-list/list/73", dsl.UrlCorreta());
  
	        page.listNew();
	        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/activity-list/new/73", dsl.UrlCorreta());
	        
	        page.activityLabel("test1");
	        assertEquals("test1", dsl.obterValorCampo("al_txt_1"));
	        
	        page.milestone("test2");
	        
	        page.activityName("test3");
	        
	        page.projectPashe("test4");
	        
	        page.WBSid("test4"); 
	        
	        page.activityDesc("test5");
	        
	        page.activitySave();

        
        
        
	}
}