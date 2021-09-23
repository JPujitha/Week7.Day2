package week7.Day2.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import week7.Day2.base.BaseServiceNow;

public class AssignIncident extends BaseServiceNow {
	public String ID;
	public AssignIncident(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public AssignIncident clickAll()   {
		driver.findElement(By.xpath(prop.getProperty("EditIncident.All.Xpath"))).click();
		return this;
	}
	public AssignIncident filterWithstate() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement fltr = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select filter=new Select(fltr);
		filter.selectByValue("state");
		WebElement up = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		up.sendKeys("New");
		up.sendKeys(Keys.ENTER);
		return this;
	}
	public AssignIncident getIdOfFirstLead() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement id = driver.findElement(By.id(prop.getProperty("AssignIncident.IncidentID.Id")));
		ID = id.getAttribute("value");
		return this;
	}
	public AssignIncident chooseAssignmentGroup() throws InterruptedException {
		driver.findElement(By.id(prop.getProperty("AssignIncident.AssignmentGroup.Id"))).click();
		Set<String> wh = driver.getWindowHandles();
		List<String> WH=new ArrayList<String>(wh);
		driver.switchTo().window(WH.get(1));
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(WH.get(0));
		Thread.sleep(800);
		return this;
	}
	public AssignIncident giveWorkNote() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Updated to software group");
		return this;
	}
	
	public AssignIncident update() {
		driver.findElement(By.id(prop.getProperty("EditIncident.Update.Id"))).click();
		return this;
	}
	public AssignIncident filterWithNumber() {
		WebElement fltrs = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select filters=new Select(fltrs);
		filters.selectByValue("number");
		WebElement srch = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		srch.sendKeys(ID);
		srch.sendKeys(Keys.ENTER);
		return this;
	}
	public AssignIncident verify() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement val = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"));
		String Value = val.getAttribute("value");
		if (Value.contains("Software")) {
			System.out.println("Assigned to Software group");	
		}
		else {
			System.out.println("Not Assigned to Software group");
		}
		return this;
		
		
	}


}
