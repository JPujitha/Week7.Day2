package week7.Day2.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import week7.Day2.base.BaseServiceNow;

public class EditIncident extends BaseServiceNow {
	boolean check2;
	boolean check1;

	public EditIncident(ChromeDriver driver,Properties prop) {
		this.driver = driver;
		this.prop=prop;
	}

	public EditIncident clickAll() {
		driver.findElement(By.xpath(prop.getProperty("EditIncident.All.Xpath"))).click();
		return this;
	}

	public EditIncident applyFilterState() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement fltr = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select filter = new Select(fltr);
		filter.selectByValue("state");
		WebElement up = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		up.sendKeys("New");
		up.sendKeys(Keys.ENTER);
		return this;
	}

	public EditIncident selectIncident() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return this;
	}

	public EditIncident updateState() {
		WebElement state = driver.findElement(By.id(prop.getProperty("EditIncident.State.Id")));
		Select State = new Select(state);
		State.selectByValue("2");
		check1 = State.equals(State);
		return this;
	}

	public EditIncident updateUgency() {
		WebElement urgency = driver.findElement(By.id(prop.getProperty("EditIncident.Urgency.Id")));
		Select Urgency = new Select(urgency);
		Urgency.selectByVisibleText("1 - High");
		check2 = Urgency.equals(Urgency);
		return this;
	}

	public EditIncident giveWorkNote() {
		driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Test");
		return this;
	}

	public EditIncident clickUpdate() {
		driver.findElement(By.id(prop.getProperty("EditIncident.Update.Id"))).click();
		return this;
	}

}
