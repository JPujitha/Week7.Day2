package week7.Day2.testcase;

import org.testng.annotations.Test;

import week7.Day2.Pages.Filters;
import week7.Day2.base.BaseServiceNow;

public class EditIncidentTest extends BaseServiceNow{
@Test
public void editIncident() throws InterruptedException {
	new Filters(driver, prop).applyFilter().edit()
	.clickAll().applyFilterState().selectIncident()
	.updateState().updateUgency().giveWorkNote().clickUpdate();
}
}
