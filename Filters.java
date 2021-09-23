package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.Day2.base.BaseServiceNow;

public class Filters extends BaseServiceNow {
	public Filters(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public Filters applyFilter() throws InterruptedException {
		WebElement filter = driver.findElement(By.id(prop.getProperty("Filters.Filter.id")));
		filter.sendKeys("Incident");
		filter.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}
	public CreateIncident create() {
	return new CreateIncident(driver, prop);
	}
	public EditIncident edit() {
	return new EditIncident(driver, prop);
	}
	public AssignIncident assign() {
		return new AssignIncident(driver, prop);
	}
	public DeleteIncident delete() {
		return new DeleteIncident(driver, prop);
		
	}
}
