package week7.Day2.testcase;

import org.testng.annotations.Test;

import week7.Day2.Pages.Filters;
import week7.Day2.base.BaseServiceNow;

public class DeleteIncidentTest extends BaseServiceNow {
	@Test
	public void deleteIncident() throws InterruptedException {
		new Filters(driver, prop).applyFilter().delete().clickAll()
		.clickIncident().clickDelete();
	}

}
