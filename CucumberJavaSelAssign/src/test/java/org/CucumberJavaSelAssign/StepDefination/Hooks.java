package org.CucumberJavaSelAssign.StepDefination;


import java.util.logging.Logger;

import org.CucumberJavaSelAssign.Utils.DriverSelector;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class Hooks {

	public static WebDriver driver ;
	Logger logger = Logger.getLogger(Hooks.class.getName());

	
	@Before
	public WebDriver getBrowserlaunch (Scenario scenario) throws InterruptedException {
		
		if(scenario.getName() != null) {
		driver = new DriverSelector().get_Driver_instance();
		}
		return driver;
		
	}

	@After

	public void afterScenario(Scenario scenario) throws InterruptedException {



		if(scenario.getStatus() != null && scenario.isFailed()) {
			try {
				logger.info(scenario.getName() + "is failed");
				final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somDriverException) {
				System.err.println(somDriverException.getMessage());
				logger.info(somDriverException.getMessage());
			}
		}
		else{
			try {
				logger.info(scenario.getName() + "is passed");

				final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somDriverException) {
				logger.info(somDriverException.getMessage());
				System.err.println(somDriverException.getMessage());
			}
		}
		driver.close();
	}


}
