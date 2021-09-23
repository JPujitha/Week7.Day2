package week7.Day2.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import week7.Day2.Pages.clickCreateLead;
import week7.Day2.base.ReadPropertiesBase;

public class CreateLeadTest extends ReadPropertiesBase{
	@BeforeClass
	public void setSheetName() {
		SheetName="create";
	}
	@Parameters({"language"})
	@Test(dataProvider="sendData")
	public void leadCreate (String fname,String lname,String cmpny,String phn) throws  InterruptedException {
		new clickCreateLead(driver, prop)
		.clickCreate()
		.entercmpny(cmpny)
		.enterFirstName(fname)
		.enterLastName(lname)
		.EnterPhone(phn)
		.clickSubmit();
	}
}
