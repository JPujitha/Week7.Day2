package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.Day2.base.ReadPropertiesBase;

public class EditLead extends ReadPropertiesBase {
	public EditLead(ChromeDriver driver,Properties prop) {
		this.driver = driver;
		this.prop=prop;
	}

	public EditLead clickPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
	}

	public EditLead givephone(String ephn) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ephn);
		return this;
	}

	public EditLead clickfind() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("DuplicateLead.FindLead.Xpath"))).click();
		Thread.sleep(3000);
		return this;
	}

	public EditLead clickonlead() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return this;
	}

	public EditLead clickedit() {
		driver.findElement(By.linkText(prop.getProperty("EditLead.Edit.linkText"))).click();
		return this;
	}

	public EditLead updatecmpny(String ecmpny) {
		driver.findElement(By.id(prop.getProperty("EditLead.CompanyName.id"))).sendKeys(ecmpny);
		return this;
	}

	public EditLead submit() {
		driver.findElement(By.name(prop.getProperty("CreateLead.Submit.name"))).click();
		return this;
	}

}
