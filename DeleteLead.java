package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import week7.Day2.base.ReadPropertiesBase;


public class DeleteLead  extends ReadPropertiesBase{
	public static String leadID;
	public DeleteLead(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public DeleteLead dClickPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
		}
		public DeleteLead dEnterPhone(String phone) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);
		return this;
		}
		public DeleteLead dFindLead() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("DuplicateLead.FindLead.Xpath"))).click();
		Thread.sleep(2000);
		return this;
		}
		public DeleteLead getId() {
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		return this;
		}
		public DeleteLead dFirstLeadClick() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(500);
		return this;
		}
		public DeleteLead clickDelete() {
		driver.findElement(By.linkText(prop.getProperty("DeleteLead.Delete.LinkText"))).click();
		return this;
		}
		public DeleteLead dClickFindLeads() {
		driver.findElement(By.linkText(prop.getProperty("FindLeads.FindLead.LinkText"))).click();
		return this;
		}
		public DeleteLead enterDeletedLeadId() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		return this;
		}
		public DeleteLead findDeleted() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("DuplicateLead.FindLead.Xpath"))).click();
		Thread.sleep(900);
		return this;
		}
		public DeleteLead dverify() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		String text1="No records to display";
		Assert.assertEquals(text, text1);
		System.out.println("Lead Deleted");
		return this;
		}

}
