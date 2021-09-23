package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.Day2.base.ReadPropertiesBase;

public class CreateLead extends ReadPropertiesBase{
	
	public CreateLead(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	public CreateLead entercmpny(String cmpny) {
	driver.findElement(By.id(prop.getProperty("CreateLead.CompanyName.id"))).sendKeys(cmpny);
	return this;
	}
	public CreateLead enterFirstName(String fname) {
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	return this;
	}
	public CreateLead enterLastName(String lname) {
	driver.findElement(By.id(prop.getProperty("CreateLead.LastName.id"))).sendKeys(lname);
	return this;
	}
	public CreateLead EnterPhone(String phn) {
	driver.findElement(By.id(prop.getProperty("CreateLead.PhoneNumber.id"))).sendKeys(phn);
	return this;
	}
	public CreateLead clickSubmit() {
	driver.findElement(By.name(prop.getProperty("CreateLead.Submit.name"))).click();
	return this;
	}
}
