package Adriel;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class SilverBulletPage {

	private DSL dsl;
	
	public SilverBulletPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setEmail(String email) {
		dsl.escreveID("email", email);
		assertEquals(email, dsl.obterValorCampo("email"));
	}
	
	public void setSenha(String senha) {
		dsl.escreveID("password", senha);
		assertEquals(senha, dsl.obterValorCampo("password"));
	}
	
	public void entrar() {
		dsl.clicaRadio("login-submit");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/projects", dsl.UrlCorreta());
	}
	
	public void inicia() {
		dsl.get("http://www.lesse.com.br/tools/silverbullet/rp2");
	}
	
	public void openProject() {
		dsl.clicaXpath("//td[3]/a/span");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/project/68", dsl.UrlCorreta());
	}
	
	public void resourceRequeriment() {
		dsl.clicaXpath("//div[4]/div/div[3]/a[2]/div/div");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/resource-requirements/list/68",
				dsl.UrlCorreta());
	}
	
	public void resourceEdit() {
		dsl.clicaXpath("//div/div/form/button");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/resource-requirements/edit/545",
				dsl.UrlCorreta());
	}
	
	public void resourceDesc(String text) {
       dsl.limpaCampoCss("#resource_description");
       dsl.escreveCss("#resource_description", text);
       assertEquals(text, dsl.obterValorCampo("resource_description"));
   }
	
	public void resourceAmont(String numb) {
		dsl.limpaCampo("required_amount_of_resource");
		dsl.escreveID("required_amount_of_resource", numb);
		assertEquals(numb, dsl.obterValorCampo("required_amount_of_resource"));
	}
	
	public void resourceUnit(String unit) {
		dsl.limpaCampo("resource_cost_per_unit");
		dsl.escreveID("resource_cost_per_unit", unit);
		assertEquals(unit, dsl.obterValorCampo("resource_cost_per_unit"));
	}
	
	public void resourceRR(String rr) {
		dsl.limpaCampoCss("#rr_txt_4");
		dsl.escreveCss("#rr_txt_4", rr);
		assertEquals(rr, dsl.obterValorCampoCss("#rr_txt_4"));
	}
	
	public void resourceSub() {

		dsl.clicaRadioCss("#activity-submit");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/resource-requirements/list/68",
				dsl.UrlCorreta());
	}
	
	public void acitivityList() {
		dsl.clicaXpath("//div[4]/div/div[3]/a[1]/div/div");
	}
	
	public void listNew() {
		
		dsl.clicaXpath("//div/div/div/div[1]/div/button[1]");
	}
	
	public void activityLabel(String txt) {
		
		dsl.escreveID("al_txt_1", txt);
	}

	public void milestone(String txt) {

		dsl.escreveID("al_txt_2", txt);
	}
	
	public void activityName(String txt) {

		dsl.escreveID("al_txt_3", txt);
	}
	
	public void projectPashe(String txt) {

		dsl.escreveID("al_txt_4", txt);
	}

	public void WBSid(String txt) {

		dsl.escreveID("al_txt_5", txt);
	}
	
	public void activityDesc(String txt) {

		dsl.escreveID("al_txt_6", txt);
	}
	
	public void activitySave() {
		
		dsl.clicaRadio("activity-submit");
	}

	public void activityEdit() {
		
		dsl.clicaRadioCss("form > .btn-default");
		dsl.limpaCampo("al_txt_1");
		dsl.escreveID("al_txt_1", "troca");
		
	}
	
	public void activityDel() {
		
		dsl.clicaRadioCss(".col-sm-3 > .btn");
		dsl.clicaRadioCss(".ajs-ok");
	}
	
	public void UploadActivity() throws InterruptedException {
		
		dsl.clicaRadioCss(".btn:nth-child(4)");
		Thread.sleep(500);
		dsl.escreveCss(".row:nth-child(1) > .col-lg-6 .form-control", "teste");
		dsl.escreveCss(".col-lg-12 > .form-group > input", System.getProperty("user.dir") + "\\src\\main\\resources\\teste.txt");
		dsl.clicaRadioCss(".modal-dialog:nth-child(2) .btn-success");
	}

	public void UploadResource() throws InterruptedException {
		
		dsl.clicaRadioCss(".col-lg-12 > .btn-info");
		Thread.sleep(500);
		dsl.escreveCss(".row:nth-child(1) > .col-lg-6 .form-control", "teste");
		dsl.escreveCss(".col-lg-12 > .form-group > input", System.getProperty("user.dir") + "\\src\\main\\resources\\teste.txt");
		dsl.clicaRadioCss(".btn-success:nth-child(1)");
	}
}