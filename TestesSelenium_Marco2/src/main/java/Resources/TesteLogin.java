package Resources;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	public static WebDriver driver;
	
	@Before
	public final void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
	}

	@Test
	public void testPrincipal() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(900, 900));
		
		driver.get("http://www.lesse.com.br/tools/silverbullet/rp2");
        driver.findElement(By.id("email")).sendKeys("iagonogueira.aluno@unipampa.edu.br");
        assertEquals("iagonogueira.aluno@unipampa.edu.br",driver.findElement(By.id("email")).getAttribute("value"));
        driver.findElement(By.id("password")).sendKeys("testesenha");
        assertEquals("testesenha",driver.findElement(By.id("password")).getAttribute("value"));
        driver.findElement(By.id("login-submit")).click();
        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/projects", driver.getCurrentUrl());
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".btn-default:nth-child(1)")).click();
        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/project/73", driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".col-lg-10:nth-child(3) > a:nth-child(2) > .timeColor > .verticalAlign")).click();
        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/activity-list/list/73", driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".col-lg-12 > .btn-info:nth-child(1)")).click();
        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/activity-list/new/73", driver.getCurrentUrl());
        driver.findElement(By.id("al_txt_1")).sendKeys("teste1");
        assertEquals("teste1", driver.findElement(By.id("al_txt_1")).getAttribute("value"));
        driver.findElement(By.id("al_txt_2")).sendKeys("teste2");
        assertEquals("teste2", driver.findElement(By.id("al_txt_2")).getAttribute("value"));
        driver.findElement(By.id("al_txt_3")).sendKeys("teste3");
        assertEquals("teste3", driver.findElement(By.id("al_txt_3")).getAttribute("value"));
        driver.findElement(By.id("al_txt_4")).sendKeys("teste4");
        assertEquals("teste4", driver.findElement(By.id("al_txt_4")).getAttribute("value"));
        driver.findElement(By.id("al_txt_5")).sendKeys("teste5");
        assertEquals("teste5", driver.findElement(By.id("al_txt_5")).getAttribute("value"));
        driver.findElement(By.id("al_txt_6")).sendKeys("teste6");
        assertEquals("teste6", driver.findElement(By.id("al_txt_6")).getAttribute("value"));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".glyphicon-ok")).click();
        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/activity-list/list/73", driver.getCurrentUrl());
        
        
        
	}
}