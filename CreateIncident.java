package week7.Day2.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.Day2.base.BaseServiceNow;

public class CreateIncident extends BaseServiceNow {
	public static String Val;

	public CreateIncident(ChromeDriver driver,Properties prop) {
		this.driver = driver;
		this.prop=prop;
	}

	public CreateIncident clickNew() {
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		return this;
	}

	public CreateIncident iconToSelectCaller() {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		return this;
	}

	public CreateIncident selectCaller() {
		Set<String> WH1 = driver.getWindowHandles();
		List<String> wh1 = new ArrayList(WH1);
		driver.switchTo().window(wh1.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(wh1.get(0));
		return this;
	}

	public CreateIncident shortDescription() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id(prop.getProperty("CreateIncident.Description.Id"))).sendKeys("Description");
		return this;
	}

	public CreateIncident storeIncidentNumber() {
		WebElement id = driver.findElement(By.id(prop.getProperty("CreateIncident.Incident.Id")));
		Val = id.getAttribute("value");
		return this;
	}

	public CreateIncident clickSubmit() throws InterruptedException {
		driver.findElement(By.id(prop.getProperty("CreateIncident.submit.Id"))).click();
		Thread.sleep(800);
		return this;
	}

	public CreateIncident searchCreatedIncident() throws InterruptedException {
		WebElement ival = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		ival.sendKeys(Val);
		ival.sendKeys(Keys.ENTER);
		Thread.sleep(800);
		return this;
	}

	public CreateIncident verifyIncident() {
		WebElement ver = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]"));
		String result = ver.getText();
		if (Val.equals(result)) {
			System.out.println("Incident created successfully");
		} else {
			System.out.println("Incident not created");
		}
		return this;
	}

}
