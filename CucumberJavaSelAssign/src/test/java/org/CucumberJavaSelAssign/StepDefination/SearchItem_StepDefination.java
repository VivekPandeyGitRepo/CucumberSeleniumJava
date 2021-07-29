package org.CucumberJavaSelAssign.StepDefination;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


import org.CucumberJavaSelAssign.Pages.SearchPageGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.SessionId;

import io.cucumber.java.en.*;


public class SearchItem_StepDefination{

	WebDriver driver;
	static Logger logger = Logger.getLogger(SearchItem_StepDefination.class.getName());

	public SearchItem_StepDefination(){
		this.driver = Hooks.driver;
	}

	SearchPageGoogle searchPgGoogle ; 

	@Given("The Browser is launched")
	public void browser_Launch() {

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		logger.info("I am inside launched Broswer sceanrio");

	}

	@And("^Verify the url (.*) is launched$")
	public void navigate_To_SerachUrl(String search_URL) {

		String urlToNavigate = search_URL;
		driver.navigate().to(urlToNavigate);
	}

	@And("^user enters (.*) for search$")
	public void text_Item_Search(String serachItem) {
		searchPgGoogle = new SearchPageGoogle(driver);
		searchPgGoogle.enterTextToSearch(serachItem);

	}

	@And("user clicks the submit button")
	public void validate_Submit_action() throws InterruptedException {

		searchPgGoogle.clickSubmitToSearch();

	}

	@Then("^Validate the user is navigated to (.*) search results$")
	public void validate_Navigated_Results(String expectedResult) throws InterruptedException {

		searchPgGoogle.validateSearchResultPage(expectedResult);

	}

	@Then("^Validate the user obtains first (.*) from results$")
	public void validate_Result_Click( String returnedResult) throws InterruptedException {

		String expectedResult = returnedResult ; 
		searchPgGoogle.validateFirstSearchResult(expectedResult);

	}


}
