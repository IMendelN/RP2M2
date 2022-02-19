package elementos;

public class SheduleDurationEstimates {
	public static final String URL = "http://www.lesse.com.br/tools/silverbullet/rp2/schedule/duration-estimates/list/84?";
	public static final String novo[] = {"//div/section/div//div/div/div[1]/div/button[1]", "xpath"};
	public static final String novoURL = "http://www.lesse.com.br/tools/silverbullet/rp2/schedule/duration-estimates/new/84";
	public static final String novoNome[] = {"activity_id", "name"};
	public static final String novoEstimatedDuration[] = { "estimated_duration", "id"};
	public static final String novoNomeSelect1[] = {"//form/ul/div[1]/select/option[2]", "xpath"};
	public static final String novoEstimatedInitDate[] = {"estimated_start_date", "id"};
	public static final String novoEstimatedEndDate[] = { "estimated_end_date", "id"};
	public static final String novoPerformedDuration[] = {"performed_duration", "id"};
	public static final String novoPerformedInitDate[] = {"performed_start_date", "id"};
	public static final String novoPerformedEndDate[] = {"performed_end_date", "id"};
	public static final String novoSubmit[] = {"activity-submit", "id"};
}
