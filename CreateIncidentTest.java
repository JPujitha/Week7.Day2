package week7.Day2.testcase;

import org.testng.annotations.Test;

import week7.Day2.Pages.Filters;
import week7.Day2.base.BaseServiceNow;

public class CreateIncidentTest extends BaseServiceNow{
	@Test
	public void createIncident() throws InterruptedException {
		new Filters(driver, prop).applyFilter().create()
		.clickNew().iconToSelectCaller()
		.selectCaller().shortDescription()
		.storeIncidentNumber().clickSubmit()
		.searchCreatedIncident().verifyIncident();
	}

}
