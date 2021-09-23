 package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.Day2.base.ReadPropertiesBase;

public class DuplicateLead extends ReadPropertiesBase {
	public DuplicateLead(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public DuplicateLead clickphone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
	}
		public DuplicateLead givephn(String phon) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phon);
		return this;
		}
		public DuplicateLead findl() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("DuplicateLead.FindLead.Xpath"))).click();
		Thread.sleep(2000);
		return this;
		}
		public DuplicateLead clickl() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return this;
		}
		public DuplicateLead clickdup() {
		driver.findElement(By.linkText(prop.getProperty("DuplicateLead.Duplicate.LinkText"))).click();
		return this;
		}
		public DuplicateLead submit() {
		driver.findElement(By.name(prop.getProperty("CreateLead.Submit.name"))).click();
		return this;
		}

}
