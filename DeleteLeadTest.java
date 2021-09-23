package week7.Day2.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import week7.Day2.Pages.FindLeads;
import week7.Day2.base.ReadPropertiesBase;

public class DeleteLeadTest extends ReadPropertiesBase {
	@BeforeClass
	public void setSheetName() {
		SheetName="delete";
	}

	@Parameters({ "language" })
	@Test(dataProvider = "sendData")
	public void deleteTest(String phone) throws InterruptedException {
		new FindLeads(driver, prop).findLeads().delete().dClickPhone().dEnterPhone(phone).dFindLead().getId()
				.dFirstLeadClick().clickDelete().dClickFindLeads().enterDeletedLeadId().findDeleted().dverify();
	}
}
