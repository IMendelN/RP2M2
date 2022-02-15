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

public class ResourceRequirements {

	private DSL dsl;

	private SilverBulletPage page;

	@Before
	public final void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(1500, 1000));
		dsl = new DSL(driver);
		page = new SilverBulletPage(driver);

	}

	@After
	public void Finalizar() {
		dsl.close();
	}

	@Test
	public void fluxoAlternativo() throws InterruptedException {

<<<<<<< HEAD:TestesSelenium_Marco2/src/main/java/Adriel/ResourceRequirements.java
	page.inicia();
	
	page.setEmail("adrielluan.aluno@unipampa.edu.br");
	
	page.setSenha("1040.shiriuuu");

    page.entrar();

    page.openProject();

    page.resourceRequeriment();

    Thread.sleep(500);
    
    page.UploadResource();
	
=======
		page.inicia();

		page.setEmail("iagonogueira.aluno@unipampa.edu.br");
		assertEquals("iagonogueira.aluno@unipampa.edu.br", dsl.obterValorCampo("email"));

		page.setSenha("testesenha");
		assertEquals("testesenha", dsl.obterValorCampo("password"));

		page.entrar();
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/projects", dsl.UrlCorreta());

		page.openProject();
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/project/68", dsl.UrlCorreta());

		page.resourceRequeriment();
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/resource-requirements/list/68",
				dsl.UrlCorreta());

		Thread.sleep(500);

		page.UploadResource();

>>>>>>> 0d6552e5a35c4e3b48b77cb1711510e8c29d5e73:TestesSelenium_Marco2/src/main/java/Resources/ResourceRequirements.java
	}
}