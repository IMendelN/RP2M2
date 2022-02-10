package Adriel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testeDelet {
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
        driver.findElement(By.id("email")).sendKeys("adrielluan.aluno@unipampa.edu.br");
        assertEquals("adrielluan.aluno@unipampa.edu.br",driver.findElement(By.id("email")).getAttribute("value"));
        driver.findElement(By.id("password")).sendKeys("1040.shiriuuu");
        assertEquals("1040.shiriuuu",driver.findElement(By.id("password")).getAttribute("value"));
        driver.findElement(By.id("login-submit")).click();
        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/projects", driver.getCurrentUrl());
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".btn-default:nth-child(1)")).click();
        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/project/73", driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".col-lg-10:nth-child(3) > a:nth-child(2) > .timeColor > .verticalAlign")).click();
        assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/activity-list/list/73", driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".fa-trash")).click();
        driver.findElement(By.xpath("//div[4]/div[2]/button")).click();
   
	}
}
