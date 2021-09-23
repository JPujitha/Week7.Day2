package week7.Day2.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import week7.Day2.Pages.FindLeads;
import week7.Day2.base.ReadPropertiesBase;

public class EditLeadTest extends ReadPropertiesBase {
	@BeforeClass
	public void setSheetName() {
		SheetName="edit";
	}
	@Parameters({"language"})
	@Test(dataProvider="sendData")
	public void editTest(String ephn,String ecmpny) throws InterruptedException {
		new FindLeads(driver,prop)
		.findLeads().edit().clickPhone()
		.givephone(ephn).clickfind().clickonlead().clickedit()
		.updatecmpny(ecmpny).submit();
	}

}
