package Ferramentas;

import org.junit.Test;

import elementos.InProjeto;
import elementos.InicioProjeto;
import elementos.Login;
import elementos.ProjScoStat;
import elementos.SheduleDurationEstimates;
import elementos.SheduleEarnedValueManagement;
import elementos.SheduleNetworkDiagram;

public class OperacoesDriver extends Driver {

	public OperacoesDriver() {
		super();
	}

	@Test
	public void fazLogin(String email, String senha) throws InterruptedException {
		Thread.sleep(500);
		sendKeys(email, Login.email);
		sendKeys(senha, Login.senha);
		click(Login.login);
		Thread.sleep(500);
	}

	@Test
	public void abreProjeto1() {
		click(InicioProjeto.AbrirProjeto1);
	}

	@Test
	public void abreScheduleNetworkDiagram() {
		click(InProjeto.SheNetDiag);
	}
	
	@Test
	public void abreScheduleDurationEstimates() {
		click(InProjeto.SheDuraEst);
	}
	@Test
	public void abreScheduleProjectCalendar() {
		click(InProjeto.SheCalProj);
	}

	@Test

	public void scheduleNetworkDiagram_Edit(String tex1, String tex2, String tex3, String tex4)
			throws InterruptedException {
		click(SheduleNetworkDiagram.Edit);

		limpaTexto(SheduleNetworkDiagram.EditTxt1);
		sendKeys(tex1, SheduleNetworkDiagram.EditTxt1);

		limpaTexto(SheduleNetworkDiagram.EditTxt2);
		sendKeys(tex2, SheduleNetworkDiagram.EditTxt2);

		limpaTexto(SheduleNetworkDiagram.EditTxt3);
		sendKeys(tex3, SheduleNetworkDiagram.EditTxt3);

		limpaTexto(SheduleNetworkDiagram.EditTxt4);
		sendKeys(tex4, SheduleNetworkDiagram.EditTxt4);
		Thread.sleep(500);

		click(SheduleNetworkDiagram.EditSubmit);
	}

	@Test
	public void scheduleNetworkDiagram_EditExcecao() throws InterruptedException {
		Thread.sleep(1000);
		click(SheduleNetworkDiagram.Edit);
		limpaTexto(SheduleNetworkDiagram.EditTxt1);
		limpaTexto(SheduleNetworkDiagram.EditTxt2);
		limpaTexto(SheduleNetworkDiagram.EditTxt3);
		limpaTexto(SheduleNetworkDiagram.EditTxt4);
		click(SheduleNetworkDiagram.EditSubmit);
	}

	@Test
	public void scheduleNetworkDiagram_Upload(String texto, String caminhoImagem) throws InterruptedException {
		click(SheduleNetworkDiagram.Upload);
		Thread.sleep(1000);
		sendKeys(texto, SheduleNetworkDiagram.UploadName);
		sendKeys(caminhoImagem, SheduleNetworkDiagram.UploadArquivo);
		click(SheduleNetworkDiagram.UploadSave);
	}

	@Test
	public void scheduleNetworkDiagram_ExcluiImagem() throws InterruptedException {
		Thread.sleep(100);
		click(SheduleNetworkDiagram.ExcluiImagem);
	}

	@Test
	public void scheduleNetworkDiagram_UploadExcecao() throws InterruptedException {
		click(SheduleNetworkDiagram.Upload);
		Thread.sleep(1000);
		click(SheduleNetworkDiagram.UploadSave);
	}

	@Test
	public void scheduleDurationEstimates_criarNovo(String duracao1, String dataInicio1, String dataFim1,
			String duracao2, String dataInicio2, String dataFim2) throws InterruptedException {
		click(SheduleDurationEstimates.novo);
		Thread.sleep(1000);
		click(SheduleDurationEstimates.novoNome);
		Thread.sleep(1000);
		click(SheduleDurationEstimates.novoNomeSelect1);
		Thread.sleep(1000);
		sendKeys(duracao1, SheduleDurationEstimates.novoEstimatedDuration);
		sendKeys(dataInicio1, SheduleDurationEstimates.novoEstimatedInitDate);
		sendKeys(dataFim1, SheduleDurationEstimates.novoEstimatedEndDate);
		sendKeys(duracao2, SheduleDurationEstimates.novoPerformedDuration);
		sendKeys(dataInicio2, SheduleDurationEstimates.novoPerformedInitDate);
		sendKeys(dataFim2, SheduleDurationEstimates.novoPerformedEndDate);
		click(SheduleDurationEstimates.novoSubmit);
	}

	@Test
	public void scheduleEarnedValueManagement_Edit(String T1, String T2, String T3, String T4, String T5, String T6,
			String T8, String T9, String T10) throws InterruptedException {
		click(SheduleEarnedValueManagement.Edit);
		Thread.sleep(1000);
		limpaTexto(SheduleEarnedValueManagement.EditEV1);
		sendKeys(T1, SheduleEarnedValueManagement.EditEV1);
		limpaTexto(SheduleEarnedValueManagement.EditPV2);
		sendKeys(T2, SheduleEarnedValueManagement.EditPV2);
		limpaTexto(SheduleEarnedValueManagement.EditAC3);
		sendKeys(T3, SheduleEarnedValueManagement.EditAC3);
		limpaTexto(SheduleEarnedValueManagement.EditBudCumuCost4);
		sendKeys(T4, SheduleEarnedValueManagement.EditBudCumuCost4);
		limpaTexto(SheduleEarnedValueManagement.EditSV5);
		sendKeys(T5, SheduleEarnedValueManagement.EditSV5);
		limpaTexto(SheduleEarnedValueManagement.EditCV6);
		sendKeys(T6, SheduleEarnedValueManagement.EditCV6);
		limpaTexto(SheduleEarnedValueManagement.EditSPI8);
		sendKeys(T8, SheduleEarnedValueManagement.EditSPI8);
		limpaTexto(SheduleEarnedValueManagement.EditCostPerInd9);
		sendKeys(T9, SheduleEarnedValueManagement.EditCostPerInd9);
		limpaTexto(SheduleEarnedValueManagement.EditEstOfComp10);
		sendKeys(T10, SheduleEarnedValueManagement.EditEstOfComp10);
		Thread.sleep(5000);
		click(SheduleEarnedValueManagement.EditSubmit);
	}
	
	@Test
	public void abreScopeStatement() throws InterruptedException {
		get(Login.URL);
		fazLogin("dionasmuller.aluno@unipampa.edu.br", "senhaTeste");
		Thread.sleep(1000);
		getDriver().manage().window().maximize();
		abreProjeto1();
		Thread.sleep(500);
		click(InProjeto.ProjScoStat);
		Thread.sleep(500);
	}
	
	public void editaScopeStatement(String t1, String t2, String t3, String t4) throws InterruptedException {
		Thread.sleep(500);
		limpaTexto(ProjScoStat.Texto1);
		sendKeys(t1 ,ProjScoStat.Texto1);
		limpaTexto(ProjScoStat.Texto2);
		sendKeys(t2 ,ProjScoStat.Texto2);
		limpaTexto(ProjScoStat.Texto3);
		sendKeys(t3 ,ProjScoStat.Texto3);
		limpaTexto(ProjScoStat.Texto4);
		sendKeys(t4 ,ProjScoStat.Texto4);
		Thread.sleep(500);
	}
	
	
}
