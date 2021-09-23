package week7.Day2.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Dp;

public class ReadPropertiesBase {
	public ChromeDriver driver;
	public String SheetName;
	public Properties prop;
	@DataProvider(indices=0)
	  public String[][] sendData() throws IOException { 
		return Dp.POI(SheetName); 
		}
	 
@Parameters({"language"})
	@BeforeMethod
	public void login(String language) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream("./src/main/resources/"+language+".properties");
		prop=new Properties();
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText(prop.getProperty("ReadPropertiesBase.Leads.LinkText"))).click();
		Thread.sleep(900);
	}
	@AfterMethod
	public void logoff() {
		driver.close();
	}


}
