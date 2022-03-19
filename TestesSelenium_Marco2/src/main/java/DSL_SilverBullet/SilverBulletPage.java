package DSL_SilverBullet;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class SilverBulletPage {
 
	private DSL dsl;
	 
	public SilverBulletPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void projeto() {
		login();
		openProject();
	}
	
	
	public void login() {
		
		inicia();
		setEmail("adrielluan.aluno@unipampa.edu.br");
		setSenha("1040.shiriuuu");
		entrar();
		
	}
	
	public void setEmail(String email) {
		dsl.escreveID("email", email);
		assertEquals(email ,dsl.obterValorCampo("email"));
	}
	
	public void setSenha(String senha) {
		dsl.escreveID("password", senha);
		assertEquals(senha ,dsl.obterValorCampo("password"));
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
	}
	
	public void resourceRequeriment() {
		dsl.clicaXpath("//div[4]/div/div[3]/a[2]/div/div");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/resource-requirements/list/73", dsl.UrlCorreta());
	}
	
	public void resourceEdit() {
		dsl.clicaXpath("//div/div/form/button");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/resource-requirements/edit/552", dsl.UrlCorreta());
	}
	
	public void resourceDesc(String text) {
       dsl.limpaCampoCss("#resource_description");
       dsl.escreveCss("#resource_description", text);
       assertEquals(text , dsl.obterValorCampo("resource_description"));
   }
	
	public void resourceAmont(String numb) {
		dsl.limpaCampo("required_amount_of_resource");
		dsl.escreveID("required_amount_of_resource", numb);
		assertEquals(numb , dsl.obterValorCampo("required_amount_of_resource"));
	}
	
	public void resourceUnit(String unit) {
		dsl.limpaCampo("resource_cost_per_unit");
		dsl.escreveID("resource_cost_per_unit", unit);
		assertEquals(unit , dsl.obterValorCampo("resource_cost_per_unit"));
	}
	
	public void resourceRR(String rr) {
		dsl.limpaCampoCss("#rr_txt_4");
		dsl.escreveCss("#rr_txt_4", rr);
		assertEquals(rr , dsl.obterValorCampoCss("#rr_txt_4"));
	}
	
	public void resourceSub() {

		dsl.clicaRadioCss("#activity-submit");
	}
	
	public void acitivityList() {
		dsl.clicaXpath("//div[4]/div/div[3]/a[1]/div/div");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/activity-list/list/73", dsl.UrlCorreta());
	}
	
	public void listNew() {
		
		dsl.clicaXpath("//div/div/div/div[1]/div/button[1]");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/activity-list/new/73", dsl.UrlCorreta());
	}
	
	public void activityLabel(String txt) {
		
		dsl.escreveID("al_txt_1", txt);
		assertEquals(txt, dsl.obterValorCampo("al_txt_1"));
	}

	public void milestone(String txt) {

		dsl.escreveID("al_txt_2", txt);
		assertEquals(txt, dsl.obterValorCampo("al_txt_2"));
	}
	
	public void activityName(String txt) {

		dsl.escreveID("al_txt_3", txt);
		assertEquals(txt, dsl.obterValorCampo("al_txt_3"));
	}
	
	public void projectPashe(String txt) {

		dsl.escreveID("al_txt_4", txt);
		assertEquals(txt, dsl.obterValorCampo("al_txt_4"));
	}

	public void WBSid(String txt) {

		dsl.escreveID("al_txt_5", txt);
		assertEquals(txt, dsl.obterValorCampo("al_txt_5"));
	}
	
	public void activityDesc(String txt) {

		dsl.escreveID("al_txt_6", txt);
		assertEquals(txt, dsl.obterValorCampo("al_txt_6"));
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
	
	public void costEstimate() {
		dsl.clicaXpath("//div[5]/div/div[3]/a/div/div");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/cost/cost-estimates/list/73", dsl.UrlCorreta());
	}
	
	public void costEstimateEdit() {
		dsl.clicaXpath("//form/button");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/cost/cost-estimates/edit/553", dsl.UrlCorreta());
	}
	
	public void custoEstimado(String numb) {
		dsl.limpaCampo("contingency_reserve");
		dsl.escreveID("estimated_cost" , numb);
		assertEquals(numb , dsl.obterValorCampo("estimated_cost"));
	}

	public void contingencyReserve(String numb) {
		dsl.limpaCampo("contingency_reserve");
		dsl.escreveID("contingency_reserve", numb);
		assertEquals(numb , dsl.obterValorCampo("contingency_reserve"));
	}
	
	public void baseLine(String numb) {
		dsl.limpaCampo("baseline");
		dsl.escreveID("baseline", numb);
		assertEquals(numb , dsl.obterValorCampo("baseline"));
	}
	
	public void realCost(String numb) {
		dsl.limpaCampo("real_cost");
		dsl.escreveID("real_cost", numb);
		assertEquals(numb , dsl.obterValorCampo("baseline"));
	}
	
	public void cumEstimateCost(String numb) {
		dsl.limpaCampo("cumulative_estimated_cost");
		dsl.escreveID("cumulative_estimated_cost", numb);
		assertEquals(numb , dsl.obterValorCampo("cumulative_estimated_cost"));
	}
	
	public void swpackage(String numb) {
		dsl.limpaCampo("sum_of_work_packages");
		dsl.escreveID("sum_of_work_packages", numb);
		assertEquals(numb , dsl.obterValorCampo("sum_of_work_packages"));
	}
	
	public void estimatedCost(String numb) {
		dsl.limpaCampo("estimated_cost");
		dsl.escreveID("estimated_cost", numb);
		assertEquals(numb , dsl.obterValorCampo("estimated_cost"));
	}
	
	public void budget(String numb) {
		dsl.limpaCampo("budget");
		dsl.escreveID("budget", numb);
		assertEquals(numb , dsl.obterValorCampo("budget"));
	}
	
	public void cumRealCost(String numb) {
		dsl.limpaCampoXpath("//form/ul/div[12]/div/input");
		dsl.escreverXpath("//form/ul/div[12]/div/input", numb);
		assertEquals(numb , dsl.obterValorCampoXpath("//form/ul/div[12]/div/input"));
	}
	
	public void replantCost(String numb) {
		dsl.limpaCampo("replanted_cost");
		dsl.escreveID("replanted_cost", numb);
		assertEquals(numb , dsl.obterValorCampo("replanted_cost"));
	}
	
	public void reservePackage(String numb) {
		dsl.limpaCampo("contingency_reserve_of_packages");
		dsl.escreveID("contingency_reserve_of_packages", numb);
		assertEquals(numb , dsl.obterValorCampo("contingency_reserve_of_packages"));
	}
	
	public void cumReplantCost(String numb) {
		dsl.limpaCampo("cumulative_replanted_cost");
		dsl.escreveID("cumulative_replanted_cost", numb);
		assertEquals(numb , dsl.obterValorCampo("cumulative_replanted_cost"));
	}
	
	public void reserve(String numb) {
		dsl.limpaCampo("reserve");
		dsl.escreveID("reserve", numb);
		assertEquals(numb , dsl.obterValorCampo("reserve"));
	}
	
	public void EarnedValue() {
		dsl.clicaXpath("//div[4]/div/div[4]/a[1]/div/div");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/schedule/earned-value-management/list/73", dsl.UrlCorreta());
	}
	
	public void costSalve() {
		dsl.clicaRadio("activity-submit");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/cost/cost-estimates/list/73" , dsl.UrlCorreta());
		
	}
	
	public void costEdit() {
		
		estimatedCost("0.01");

		contingencyReserve("0.1");
		
		baseLine("0.01");
		
		realCost("0.01");
		
		cumEstimateCost("0.01");
		
		swpackage("0.01");
		
		budget("0.01");
		
		cumRealCost("0.1");
		
		replantCost("0.01");
		
		contingencyReserve("0.01");
		
		reservePackage("0.01");

		cumReplantCost("0.01");
	
		cumRealCost("0.01");

		costSalve();
	}
	
	public void ChengeRequest () {
		
		dsl.clicaXpath("//div/div[2]/a[4]/div/div");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/integration/change-request/list/73", dsl.UrlCorreta());
		
	}

	public void PartesInt() {
		
		dsl.clicaXpath("//div[11]/div/div[2]/a[1]/div/div");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/stakeholder/stakeholder-register/list/73", dsl.UrlCorreta());
		dsl.clicaXpath("//div/div/div/div[1]/div/button");
		
	}
	
	public void Marcos() {
		
		
		dsl.clicaXpath("//div/div/div/div[1]/div/button");
		
		dsl.escreveID("shr_txt_1", "Marcos Eduardo Lopes Silva");
		assertEquals("Marcos Eduardo Lopes Silva", dsl.obterValorCampo("shr_txt_1"));
		
		dsl.selecionarComboName("type", 1);
		assertEquals(dsl.obterValorComboName("type"), "Internal");
		
		dsl.selecionarComboName("role", 3);
		assertEquals(dsl.obterValorComboName("role"), "Project manager");
		
		dsl.escreveID("shr_txt_4", "Unipampa");
		assertEquals("Unipampa", dsl.obterValorCampo("shr_txt_4"));
		
		dsl.escreveID("shr_txt_5", "Leader");
		assertEquals("Leader", dsl.obterValorCampo("shr_txt_5"));
		
		dsl.escreveID("shr_txt_6", "marcoseduardo.aluno@unipampa.edu.br");
		assertEquals("marcoseduardo.aluno@unipampa.edu.br", dsl.obterValorCampo("shr_txt_6"));
		
		dsl.escreveID("shr_txt_7", "Gerencia e supervisao de projetos");
		assertEquals("Gerencia e supervisao de projetos", dsl.obterValorCampo("shr_txt_7"));
		
		dsl.escreveID("phone_number", "(051)99999-9999");
		
		dsl.escreveID("shr_txt_9", "Home Office");
		assertEquals("Home Office", dsl.obterValorCampo("shr_txt_9"));
		
		dsl.escreveID("shr_txt_10", "Apenas teste de Rpll");
		assertEquals("Apenas teste de Rpll", dsl.obterValorCampo("shr_txt_10"));
		
		dsl.escreveID("shr_txt_11","Testar SilverBullet" );
		assertEquals("Testar SilverBullet", dsl.obterValorCampo("shr_txt_11"));
		
		dsl.escreveID("shr_txt_12","Terminar o Semestre");
		assertEquals("Terminar o Semestre", dsl.obterValorCampo("shr_txt_12"));
		
		dsl.escreveID("shr_txt_13", "Teste de RPll");
		assertEquals("Teste de RPll", dsl.obterValorCampo("shr_txt_13"));
		
		dsl.clicaRadio("stakeholder-submit");
		
	}
	
	public void Adriel() {
		
		dsl.escreveID("shr_txt_1", "Adriel Luan da Silveira");
		
		dsl.selecionarComboName("type", 1);
		assertEquals(dsl.obterValorComboName("type"), "Internal");
		
		dsl.selecionarComboName("role", 3);
		assertEquals(dsl.obterValorComboName("role"), "Project manager");
		
		dsl.escreveID("shr_txt_4", "Unipampa");
		assertEquals("Unipampa", dsl.obterValorCampo("shr_txt_4"));
		
		dsl.escreveID("shr_txt_5", "Leader");
		assertEquals("Leader", dsl.obterValorCampo("shr_txt_5"));
		
		dsl.escreveID("shr_txt_6", "adrielluan.aluno@unipampa.edu.br");
		assertEquals("adrielluan.aluno@unipampa.edu.br", dsl.obterValorCampo("shr_txt_6"));
		
		dsl.escreveID("shr_txt_7", "Gerencia e supervisao de projetos");
		assertEquals("Gerencia e supervisao de projetos", dsl.obterValorCampo("shr_txt_7"));
		
		dsl.escreveID("phone_number", "(051)99999-9999");
		
		dsl.escreveID("shr_txt_9", "Home Office");
		assertEquals("Home Office", dsl.obterValorCampo("shr_txt_9"));
		
		dsl.escreveID("shr_txt_10", "Apenas teste de Rpll");
		assertEquals("Apenas teste de Rpll", dsl.obterValorCampo("shr_txt_10"));
		
		dsl.escreveID("shr_txt_11","Testar SilverBullet" );
		assertEquals("Testar SilverBullet", dsl.obterValorCampo("shr_txt_11"));
		
		dsl.escreveID("shr_txt_12","Terminar o Semestre");
		assertEquals("Terminar o Semestre", dsl.obterValorCampo("shr_txt_12"));
		
		dsl.escreveID("shr_txt_13", "Teste de RPll");
		assertEquals("Teste de RPll", dsl.obterValorCampo("shr_txt_13"));
		
		dsl.clicaRadio("stakeholder-submit");
	}
	
	public void Chenge() {
		 
		dsl.selecionarComboName("requester", 1);
		dsl.escreveID("number_id", "1");
		dsl.selecionarCombo("type", "Preventive Action");
		assertEquals(dsl.obterValorCombo("type"), "Preventive Action");
		dsl.selecionarCombo("status", "Canceled");
		assertEquals(dsl.obterValorCombo("status"), "Canceled");
		dsl.escreveID("request_date", "01/01/2000");
		dsl.escreveID("committee_date", "01/01/2200");
		dsl.escreveID("description", "trabelho de RPll");
		dsl.escreveID("impacted_areas", "Resolucoes de problemas");
		dsl.escreveID("impacted_docs", "Relatorios de RP");
		dsl.escreveID("justification", "Relatorios");
		dsl.escreveID("comments", "Apenas teste");
		dsl.escreveID("committee_opinion", "Apenas para testes novos");
		dsl.escreveID("manager_opinion", "Teste final");
		dsl.clicaRadio("change_request-submit");
		
	}
	
	public void ChengeEdit() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		dsl.clicaXpath("//div/div/div[1]/div[2]/div/div/div[2]/div/table/tbody/tr/td[7]/div/div[1]/form/button");
		
		dsl.selecionarCombo("status", "Approved");
		assertEquals(dsl.obterValorCombo("status"), "Approved");
		
		dsl.selecionarComboName("requester", 2);
		
		dsl.clicaRadio("change_request-submit");
		assertEquals("http://www.lesse.com.br/tools/silverbullet/rp2/integration/change-request/list/73", dsl.UrlCorreta());
		
	}

	public void ChengeDel() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		dsl.clicaXpath("//div/div/div[1]/div[2]/div/div/div[2]/div/table/tbody/tr/td[7]/div/div[2]/form/button");
		
	}
	
	public void updateCost() {
		
		dsl.clicaXpath("//div/div/div/div[1]/div/button");
		dsl.escreverXpath("//*[@id='img']/div[1]/div/div/input", "teste");
		dsl.escreverXpath("//form/div[2]/div/div/input", System.getProperty("user.dir") + "\\src\\main\\resources\\teste.txt");
		dsl.clicaXpath("//*[@id='upload']/div[2]/div/div[3]/div/div/button[1]");
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
		dsl.escreveCss(".col-lg-12 > .form-group > input", System.getProperty("user.dir") + "\\src\\main\\resources\\ImagemTestes.png");
		dsl.clicaRadioCss(".btn-success:nth-child(1)");
	}
	
	public void UploadCostEstimate() throws InterruptedException {
		dsl.clicaXpath("//div/div/div/div[1]/div/button");
		Thread.sleep(500);
		dsl.escreverXpath("//*[@id='img']/div[1]/div/div/input", "teste");
		dsl.escreverXpath("//*[@id='img']/div[1]/div/div/input", System.getProperty("user.dir") + "\\src\\main\\resources\\ImagemTestes.png");
		dsl.clicaXpath("//*[@id='upload']/div[2]/div/div[3]/div/div/button[1]");
	}
	
	public void UploadManegement() throws InterruptedException {
		dsl.clicaXpath("//div/div/div/div[1]/div/button");
		Thread.sleep(500);
		dsl.escreverXpath("//*[@id='img']/div[1]/div/div/input", "teste");
		dsl.escreverXpath("//*[@id='img']/div[2]/div/div/input", System.getProperty("user.dir") + "\\src\\main\\resources\\ImagemTestes.png");
		dsl.clicaXpath("//*[@id='upload']/div[2]/div/div[3]/div/div/button[1]");
	}
}
