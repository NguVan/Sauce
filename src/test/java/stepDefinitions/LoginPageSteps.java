package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Constants;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {;
	private static String currentUrl;
	private static String actualerrorText;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get(Constants.URL);

	}

	@When("user fills the userName and password from given sheetname {string} and rownumber {int}")
	public void user_fills_the_user_name_and_password_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) 
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);

		String userName = testData.get(rowNumber).get("username");
		String passWord = testData.get(rowNumber).get("password");
		// enter User name
		loginPage.enterUserName(userName);
		// enter Password
		loginPage.enterPassword(passWord);	
		
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();

	}

	@Then("user gets the current URL")
	public void user_gets_the_current_url() {
		currentUrl = loginPage.getCurrentUrl();
		System.out.println("the current Url is: " +currentUrl);
	}

	@Then("page URL should be contain {string}")
	public void page_url_should_be_contain(String expectedUrl) {
		Assert.assertTrue(currentUrl.contains(expectedUrl));

	}

	@Then("user gets the error message")
	public void user_gets_the_error_message() {
		actualerrorText = loginPage.errorMessageText();		
		System.out.println("The error message is: " +actualerrorText);

		
	}

	@Then("the error message should be contain from given sheetname {string} and rownumber {int}")
	public void the_error_message_should_be_contain_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) 
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);
		String expectedErrorMessage = testData.get(rowNumber).get("message");
		System.out.println("The expected message from excel file: " +expectedErrorMessage);
		Assert.assertTrue(actualerrorText.contains(expectedErrorMessage));

	}

}
