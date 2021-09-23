package week7.Day2.testcase;

import org.testng.annotations.Test;

import week7.Day2.Pages.Filters;
import week7.Day2.base.BaseServiceNow;

public class AssignIncidentTest extends BaseServiceNow{
	@Test
	public void Assign() throws InterruptedException {
		new Filters(driver, prop).applyFilter().assign().clickAll()
		.filterWithstate().getIdOfFirstLead().chooseAssignmentGroup()
		.giveWorkNote().update().filterWithNumber().verify();
	}

}
