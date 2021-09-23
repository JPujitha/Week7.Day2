package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.Day2.base.ReadPropertiesBase;

public class clickCreateLead extends ReadPropertiesBase{
	public clickCreateLead(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;

	}
	public CreateLead clickCreate() throws InterruptedException {
		driver.findElement(By.linkText(prop.getProperty("clickCreateLead.CreateLead.LinkText"))).click();
		Thread.sleep(1000);
		return new CreateLead(driver, prop);

	}

}
