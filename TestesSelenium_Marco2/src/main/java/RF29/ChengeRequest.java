package RF29;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import DSL_SilverBullet.DSL;
import DSL_SilverBullet.SilverBulletPage;

public class ChengeRequest {
	
	private DSL dsl;
	private SilverBulletPage page;

	@Before
	public final void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(1500, 1500));
		new DSL(driver);
		page = new SilverBulletPage(driver);
		dsl = new DSL(driver);
	}

	@After
	public void Finalizar() {
		dsl.close();
	}
	
	@Test 
	public void Criacao() {
		
		page.login();

		page.openProject();
		
		page.PartesInt();
		
		page.Adriel();
		
		page.Marcos();
	}

	@Test
	public void FluxoPrincipal() throws InterruptedException {

		page.login();

		page.openProject();
		
		page.ChengeRequest();
		
		dsl.clicaXpath("//div/div/div[1]/div[1]/div/button");
		
		page.Chenge();

	}
	
	@Test 
	public void ChengeEdit() {
		
		page.login();

		page.openProject();
		
		page.ChengeRequest();
		
		page.ChengeEdit();
		
	}
	
	@Test 
	public void ChengeExcluir() {
		page.login();

		page.openProject();
		
		page.ChengeRequest();
		
		page.ChengeDel();
		
	}
}
