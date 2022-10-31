package stepDefinitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.InventoryPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Constants;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InventorySteps {
	private static String actualbadgeNumber;
	private static String expectedbadgeNumber;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private InventoryPage inventoryPage = new InventoryPage(DriverFactory.getDriver());
	
	@Given("user is on Inventory page when login from given sheetname {string} and rownumber {int}")
	public void user_is_on_inventory_page_when_login_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		DriverFactory.getDriver().get(Constants.URL);
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);
		String userName = testData.get(rowNumber).get("username");
		String passWord = testData.get(rowNumber).get("password");
		loginPage.login(userName, passWord);

	}

	@When("user add to cart single product from given sheetname {string} and rownumber {int}")
	public void user_add_to_cart_single_product_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);
		String productName = testData.get(rowNumber).get("product_01");
		System.out.println("product name"+productName);
		inventoryPage.InventoryItemAction(productName, "Add to cart");
	}

	@Then("user get the shopping cart badge number")
	public void user_get_the_shopping_cart_badge_number() {
		actualbadgeNumber = inventoryPage.CartBadge();
		System.out.println("Actual cart badge is: "+actualbadgeNumber);

	}

	@Then("the badge number should be contain from given sheetname {string} and rownumber {int}")
	public void the_badge_number_should_be_contain_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) 
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);
		expectedbadgeNumber =  testData.get(rowNumber).get("badgenotify");
		System.out.println("The expected cart badge is: " +expectedbadgeNumber);
		Assert.assertEquals(actualbadgeNumber, expectedbadgeNumber);


	}

	@When("user remove the single product from given sheetname {string} and rownumber {int}")
	public void user_remove_the_single_product_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);
		String productName = testData.get(rowNumber).get("product_01");
		inventoryPage.InventoryItemAction(productName, "Remove");

	}

	@Then("the badge number should not display")
	public void the_badge_number_should_not_display() {
		ElementUtil.isInvisibilityOfElementLocated(InventoryPage.getCartBadge);
		
	}

	@When("user add to cart multi products from given sheetname {string} and rownumber {int}")
	public void user_add_to_cart_multi_products_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) 
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);
		String productName01 = testData.get(rowNumber).get("product_01");
		String productName02 = testData.get(rowNumber).get("product_02");
		inventoryPage.InventoryItemAction(productName01, "Add to cart");
		inventoryPage.InventoryItemAction(productName02, "Add to cart");
	}

	@When("user remove the multi products from given sheetname {string} and rownumber {int}")
	public void user_remove_the_multi_products_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);
		String productName01 = testData.get(rowNumber).get("product_01");
		String productName02 = testData.get(rowNumber).get("product_02");
		inventoryPage.InventoryItemAction(productName01, "Remove");		
		inventoryPage.InventoryItemAction(productName02, "Remove");	

	}

	@When("user go to product detail from given sheetname {string} and rownumber {int}")
	public void user_go_to_product_detail_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) 
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("SauceData.xlsx", sheetName);
		String productName = testData.get(rowNumber).get("product_01");
		inventoryPage.gotoInventoryDetail(productName);		
	}
	@When("user add to cart from product detail")
	public void user_add_to_cart_from_product_detail() {
		inventoryPage.InventoryItemAction("Add to cart");
	}

	@When("user remove the single product")
	public void user_remove_the_single_product() {
		inventoryPage.InventoryItemAction("Remove");
	}

}
