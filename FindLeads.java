 package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.Day2.base.ReadPropertiesBase;


public class FindLeads extends ReadPropertiesBase {
public FindLeads(ChromeDriver driver,Properties prop) {
	this.driver=driver;
	this.prop=prop;
}
public FindLeads findLeads() throws InterruptedException {
	driver.findElement(By.linkText(prop.getProperty("FindLeads.FindLead.LinkText"))).click();
	Thread.sleep(800);
	return this;	
}
public EditLead edit() {
	return new EditLead(driver, prop);	
}
public DeleteLead delete() {
	return new DeleteLead(driver, prop);	
}
public DuplicateLead duplicate() {
	return new DuplicateLead(driver, prop);
}
}































