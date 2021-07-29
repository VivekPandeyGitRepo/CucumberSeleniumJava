package org.CucumberJavaSelAssign.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

public class DriverSelector {
	//public static WebDriver driver;

	String browser_name =  "chrome";
	public WebDriver get_Driver_instance() {

		System.out.println("Called get_Driver_instance");

		if(browser_name != null && browser_name.equalsIgnoreCase("chrome")) {

			String userPath = System.getProperty("user.dir");
			System.out.println(userPath);
			System.setProperty("webdriver.chrome.driver", userPath+"/src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); 
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			WebDriver driver = new ChromeDriver(options);
			SessionId current_SessionId = ((ChromeDriver)driver).getSessionId();
			System.out.println(" CURRENT current_SessionId 8*** " + current_SessionId);
			return  driver;
		}

		else if(browser_name != null && browser_name.equalsIgnoreCase("firefox")) {
			String userPath = System.getProperty("user.dir");
			System.out.println(userPath);
			System.setProperty("webdriver.gecko.driver", userPath+"/src/test/resources/drivers/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			return new FirefoxDriver();
		}

		else {
			String userPath = System.getProperty("user.dir");
			System.out.println(userPath);
			System.setProperty("webdriver.chrome.driver", userPath+"/src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); 
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions"); 
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			WebDriver driver = new ChromeDriver(options);
			SessionId current_SessionId = ((ChromeDriver)driver).getSessionId();
			return  driver;
			


		}

	}


}
