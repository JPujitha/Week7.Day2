package week7.Day2.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseServiceNow {
	public ChromeDriver driver;
	public Properties prop;
	@BeforeMethod
	public void preCondition() throws InterruptedException, IOException {
		FileInputStream fis= new FileInputStream("./src/main/resources/snow.properties");
		prop= new Properties();
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("user_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
			}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}
