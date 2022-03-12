package elementos;

public class ScheduleProjectCalendar {
	public static final String URL = "http://www.lesse.com.br/tools/silverbullet/rp2/schedule/project-calendars/list/68";
	public static final String PCURL[] = {"//div[4]/div/div[2]/a[3]/div/div", "xpath"};
	public static final String edit[] = {"//em", "xpath"};
	public static final String save[] = {"//div[8]/button", "xpath"};
	public static final String ActivityName[] = {"//div/div/div/form/ul/div[1]/select", "xpath"};
	public static final String StakeHolder[] = {"//div/div/div/form/ul/div[2]/select", "xpath"};
	public static final String Function[]= {"//*[@id=\"pca_txt_2\"]", "xpath"};
	public static final String AvailabilityStart [] = {"//*[@id=\"availability_start\"]", "xpath"};
	public static final String AvailabilityEnds [] = {"//*[@id=\"availability_ends\"]", "xpath"};
	public static final String AllocationStart [] = {"//*[@id=\"allocation_start\"]", "xpath"};
	public static final String AllocationEnds[] = {"//*[@id=\"allocation_ends\"]", "xpath"};
	public static final String upload[] = {"(//button[@type='button'])[6]", "xpath"};
	public static final String uploadImage[] = {".col-lg-12 > .form-group > input", "css"};
	public static final String uploadName[] = {"//input[@name='alt']", "xpath"};
	public static final String uploadSave[] = {"//div[3]/div/div/button/i", "xpath"};
	public static final String delete[] = {"//div/div/div/div[4]/div/div/table/tbody/tr/td[4]/div/div/a", "xpath"};
	
}
