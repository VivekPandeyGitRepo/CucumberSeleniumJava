package org.CucumberJavaSelAssign.Pages;

import java.util.List;
import java.util.logging.Logger;

import org.CucumberJavaSelAssign.Utils.DriverSelector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.org.apache.xerces.internal.dom.AbortException;



public class SearchPageGoogle {
	static Logger logger = Logger.getLogger(SearchPageGoogle.class.getName());

	WebDriver driver ;

	By text_searchBox = By.name("q");
	By button_SearchSubmit = By.xpath("(//input[@name='btnK'])[1]");
	By first_SearchResult = By.xpath("//div[@id=\"rso\"]//h3");

	public SearchPageGoogle(WebDriver driver) {
		this.driver = driver;

	}

	public void enterTextToSearch(String textToSearch) {
		WebElement input_text = driver.findElement(text_searchBox);



		if(input_text.isDisplayed()) {

			input_text.sendKeys(textToSearch);
			logger.info("The text to be searched is entered Successfully");
			System.out.println("The text to be searched is entered Successfully");
		}
		else {
			System.out.println("The text to be searched is Not entered Successfully");
			logger.info("The text to be searched is Not entered Successfully");
			driver.close();
		}
	}

	public void clickSubmitToSearch() throws InterruptedException {

		hardWait(3000);
		WebElement submitButton = driver.findElement(button_SearchSubmit);
		elementToclick(submitButton, 3000);
		logger.info("Submit Button Cick");

	}


	public void validateSearchResultPage (String expectedResult) throws InterruptedException {
		hardWait(3000);
		String pageSource = driver.getPageSource();
		pageSource.contains(expectedResult);
		Assert.assertTrue(pageSource.contains(expectedResult));
		logger.info("search action is Successfully");
	}

	public void validateFirstSearchResult(String returnedResult) throws InterruptedException {
		String expectedFirstValue = returnedResult;
		logger.info("expectedFirstValue  value :"+ expectedFirstValue );
		try {
			hardWait(3000);
			List<WebElement> searchResultList = driver.findElements(first_SearchResult);
			logger.info("searchResultList size value :"+ searchResultList.size() );

			String firstResultvalue = searchResultList.get(0).getText();
			logger.info("firstResultvalue fetched value : " + firstResultvalue);
			hardWait(3000);

			Assert.assertTrue("Results is :", firstResultvalue.contains(expectedFirstValue));
			logger.info("validateFirstSearchResult Completed");
		}finally {
			logger.info("Executed the validateFirstSearchResult Method");
		}
	}


	/*Methods*/
	public void hardWait(int timeinMiliseconds) throws InterruptedException {
		Thread.sleep(timeinMiliseconds);
		logger.info("INSIDE HARD WAIT ");
	}

	public void elementToclick(WebElement element , int timeInMilliSeconds) {
		if(element.isEnabled()) {
			logger.info("element is enabled: " + element);
			element.click();
			logger.info("element is clicked : " + element);

		}
		else{
			logger.info("element Not available for click " + element);
		}


	}

}
