package DSL_SilverBullet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
 
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	public void escreveID(String id_campo, String text) {
		driver.findElement(By.id(id_campo)).sendKeys(text);
	}
	
	public void escreverXpath(String id_campo, String text) {
		driver.findElement(By.xpath(id_campo)).sendKeys(text);
	}
	
	public void escreveCss(String css_selector, String text) {
		driver.findElement(By.cssSelector(css_selector)).sendKeys(text);
		
	}
	
	public void escreveBody(String body_campo, String text) {
		driver.findElement(By.name(body_campo)).sendKeys(text);
	}
	
	public String obterValorCampo(String id_campo) {
		
	return driver.findElement(By.id(id_campo)).getAttribute("value");
		 
	} 
	
	public String obterValorCampoCss(String id_campo) {
		
		return driver.findElement(By.cssSelector(id_campo)).getAttribute("value");
			 
		}
	
	public String obterValorCampoXpath(String id_campo) {
		
		return driver.findElement(By.xpath(id_campo)).getAttribute("value");
			 
		}
	
	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();	
	}

	public String obterValorComboName(String name) {
		WebElement element = driver.findElement(By.name(name));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
		
	}
	
	
	public void limpaCampo(String id_campo) {
		driver.findElement(By.id(id_campo)).clear();
		}

	public void limpaCampoCss(String css_campo) {
		driver.findElement(By.cssSelector(css_campo)).clear();
		}

	public void limpaCampoXpath(String xpath_campo) {
		driver.findElement(By.xpath(xpath_campo)).clear();
	}
 
	public void clicaRadio(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}
	
	public void clicaRadioCss(String css_campo) {
		driver.findElement(By.cssSelector(css_campo)).click();
	}
	
	public void clicaXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void clicaBody(String body_campo) {
		
		driver.findElement(By.name(body_campo)).click();
	}
	
	public void get(String url) {
		driver.get(url);
		
	}
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		
	}
	 
	public void selecionarComboName(String name, int valor) {
		
		WebElement element = driver.findElement(By.name(name));
		Select combo = new Select(element);
		combo.selectByIndex(valor);
		 
	}
	
	
	public String UrlCorreta() {

		return driver.getCurrentUrl();
	}

	public void close() {
		driver.close();
	}
	
	
	
}
