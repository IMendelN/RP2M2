package Resources;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Adriel.DSL;
import Adriel.SilverBulletPage;

public class CostEstimates {
	
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
	public void FluxoPrincipal() throws InterruptedException {

		page.login();

		page.openProject();
		
		page.costEstimate();
		
		Thread.sleep(500);
		
		page.costEstimateEdit();
		
		page.costEdit();
		
	}
}
