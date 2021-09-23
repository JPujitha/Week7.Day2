package week7.Day2.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import week7.Day2.Pages.FindLeads;
import week7.Day2.base.ReadPropertiesBase;

public class DuplicateLeadTest extends ReadPropertiesBase{
@BeforeClass
public void setSheetName() {
	SheetName="delete";
}
@Parameters({"language"})
@Test(dataProvider="sendData")
public void duplicate(String phon) throws InterruptedException {
	new FindLeads(driver, prop).findLeads().duplicate().clickphone()
	.givephn(phon).findl().clickl().clickdup().submit();
	
}
}
