package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.Day2.base.BaseServiceNow;

public class DeleteIncident extends BaseServiceNow {
	public DeleteIncident(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
}
	public DeleteIncident clickAll() {
		driver.findElement(By.xpath(prop.getProperty("EditIncident.All.Xpath"))).click();
		return this;
	}
	public DeleteIncident clickIncident() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement incident = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		incident.click();
		return this;
	}
	public DeleteIncident clickDelete() {
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		WebElement button = driver.findElement(By.id("ok_button"));
		String text = button.getText();
		button.click();
		if (text.contains("Delete")) {
			System.out.println("Incident Deleted");
		} else {
			System.out.println("Incident not Deleted");

		}
		return this;
	}


}

