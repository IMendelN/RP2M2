package Ferramentas;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	WebDriver driver;

	public Driver() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(675, 450));
	}

	public void get(String url) {
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getText(String elemento, String by) {
		return getElemento(elemento, by).getText();
	}
	
	public String getTextCsv(String comando) {
		String comandos[] = comando.split("<> ");
		return getText(comandos [0], comandos [1]);
	}
	
	public String getValue(String elemento, String by) {
		return getElemento(elemento, by).getAttribute("value");
	}
	
	public String getValueCsv(String comando) {
		String comandos[] = comando.split("<> ");
		return getValue(comandos [0], comandos [1]);
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void navegate(String url) {
		driver.navigate().to(url);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void click(String elemento, String by) {
		getElemento(elemento, by).click();
	}

	public void sendKeys(String texto, String elemento, String by) {
		getElemento(elemento, by).sendKeys(texto);
	}

	public void sendKeysCsv(String comando) {
		String comandos[] = comando.split("<> ");
		sendKeys(comandos[0], comandos[1], comandos[2]);
	}

	public void clickCsv(String comando) {
		String comandos[] = comando.split("<> ");
		click(comandos[0], comandos[1]);
	}

	public WebElement getElemento(String elemento, String by) {
		WebElement elementoEscolhido = null;
		switch (by) {
		case "css":
			elementoEscolhido = driver.findElement(By.cssSelector(elemento));
			break;
		case "id":
			elementoEscolhido = driver.findElement(By.id(elemento));
			break;
		case "xpath":
			elementoEscolhido = driver.findElement(By.xpath(elemento));
			break;
		}
		return elementoEscolhido;
	}
}
