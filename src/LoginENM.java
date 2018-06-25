
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class LoginENM {

	private String ENM_URL = "https://ieatenm5429-6.athtem.eei.ericsson.se";
	private String username = "Administrator", password = "TestPassw0rd";

	WebDriver driver;

	@Test
	public void loginToENM_Firefox() {
		
		System.setProperty("webdriver.gecko.driver",
                "C:\\bin\\geckodriver\\geckodriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		FirefoxOptions firefoxOptions; firefoxOptions = new FirefoxOptions(); 
		firefoxOptions.setCapability("marionette", false);
		
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		
		driver.get(ENM_URL);
		login();

	}
	
	@Test
	public void loginToENM_Chrome() throws InterruptedException {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
		  /* Enable logging */
		  System.setProperty("webdriver.chrome.logfile", "D:\\chromedriver.log");
		  System.setProperty("webdriver.chrome.verboseLogging", "true");
		  
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("no-sandbox");
		  /* Prevents Chrome Automation Extension, and browser, from crashing*/
		  options.addArguments("disable-extensions");  

		  driver = new ChromeDriver(options);
		  login();
		  	
	}
	
	public void login(){
		  driver.get(ENM_URL); /* Visit portal*/
		    
		  WebElement OK = driver.findElement(By.id("loginNoticeOk"));
		  OK.click();

		  /* Enter user/pass*/
		  WebElement userElement = driver.findElement(By.name("IDToken1"));
		  	userElement.sendKeys(username);	
		  WebElement passElement = driver.findElement(By.name("IDToken2"));
		  	passElement.sendKeys(password);
		  
		  WebElement submit = driver.findElement(By.id("submit"));
		  	submit.click();
		  WebElement continueButton = driver.findElement(By.id("continueButton"));
		  	continueButton.click();
	}

	@After
	public void quitBrowser() {
		driver.quit();
	}
}