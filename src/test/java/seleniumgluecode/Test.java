package seleniumgluecode;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Test {

	
		public static WebDriver driver;
		
		
		@Given("^user is on DigitalBank home page$")
		public void user_is_on_DigitalBank_home_page() throws Throwable {
			System.setProperty("webdriver.chrome.driver", "C:/Users/Manjunath.patil/eclipse-workspace/Selenium_Cucumber_DigitalBank/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("http://dbankdemo.com/login");
		}
		
		@When("^user enters credentials to Login$")
		public void user_enters_credentials_to_Login(DataTable usercredentials) throws Throwable {
			List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
			driver.findElement(By.id("username")).sendKeys(data.get(0).get("Username"));
		    driver.findElement(By.id("password")).sendKeys(data.get(0).get("Password"));
		    driver.findElement(By.id("submit")).click();
		}
		
		@Then("^user should be navigated to home page$")
		public void user_should_be_navigated_to_home_page() throws Throwable {
			 System.out.println(driver.getTitle());
		}
		
		@Then("^I click on Transfer link in that Between account$")
		public void i_click_on_Transfer_link_in_that_Between_account() throws Throwable {
			driver.findElement(By.xpath("//a/i[@class='menu-icon fa fa-random']")).click();
		    driver.findElement(By.xpath("//a[contains(text(), 'Between Accounts')]")).click();
		}
		
		@Then("^I should be navigated to Transfer page$")
		public void i_should_be_navigated_to_Transfer_page() throws Throwable {
			System.out.println(driver.getTitle());
		
		}
		
		
		@Given("^I am on Transfer page$")
		public void i_am_on_Transfer_page() throws Throwable {
			System.out.println(driver.getTitle());
		}
		
		@Given("^I select the FROM and TO Account from drop down$")
		public void i_select_the_FROM_and_TO_Account_from_drop_down(DataTable userdetials) throws Throwable {
			List<Map<String,String>> data = userdetials.asMaps(String.class,String.class);
			driver.findElement(By.id("fromAccount")).sendKeys(data.get(0).get("FROM"));
		    driver.findElement(By.id("toAccount")).sendKeys(data.get(0).get("TO"));
		}
		
		@Given("^enter the transfer money and click on submit button$")
		public void enter_the_transfer_money_and_click_on_submit_button(DataTable Transdetials) throws Throwable {
			List<Map<String,String>> data = Transdetials.asMaps(String.class,String.class);
			driver.findElement(By.id("amount")).sendKeys(data.get(0).get("Transfer Money"));
			driver.findElement(By.xpath("//div[@class='card-footer']/button[1]")).click();
			
		}
		
		@Then("^Money should be transferred successfully with Transaction details\\.$")
		public void money_should_be_transferred_successfully_with_Transaction_details() throws Throwable {
			System.out.println(driver.getTitle());
			System.out.println(driver.findElement(By.xpath("//div[@class='card']/div[2]/div/div[2]/div/table[@id='transactionTable']/tbody/tr[1]/td[4]")).getText());
			driver.findElement(By.xpath("//a[@class='navbar-brand']/img[@alt='Logo']")).click();
		}
		
		@Given("^I am on Transfer page2$")
		public void i_am_on_Transfer_page2() throws Throwable {
			driver.findElement(By.xpath("//a[@class='navbar-brand']/img[@alt='Logo']")).click();
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//a/i[@class='menu-icon fa fa-random']")).click();
		    driver.findElement(By.xpath("//a[contains(text(), 'Between Accounts')]")).click();
		}
		
		@Given("^enter the transfer money and click on Reset button$")
		public void enter_the_transfer_money_and_click_on_Reset_button(DataTable Transdetials) throws Throwable {
			List<Map<String,String>> data = Transdetials.asMaps(String.class,String.class);
			driver.findElement(By.id("amount")).sendKeys(data.get(0).get("Transfer Money"));
			driver.findElement(By.xpath("//div[@class='card-footer']/button[2]")).click();
		}

		@Then("^From Account, To account and Transfer Amount filed should be Reset to default values\\.$")
		public void from_Account_To_account_and_Transfer_Amount_filed_should_be_Reset_to_default_values() throws Throwable {
			System.out.println(driver.findElement(By.id("fromAccount")).getText());
			System.out.println(driver.findElement(By.id("toAccount")).getText());
		    System.out.println(driver.findElement(By.id("amount")).getText());
		}


		@Then("^verify the error message\\(The amount <Transfer money> requested for transfer is more than the available balance <Balance amount>\\)$")
		public void verify_the_error_message_The_amount_Transfer_money_requested_for_transfer_is_more_than_the_available_balance_Balance_amount() throws Throwable {
		 String act= driver.findElement(By.xpath("//div[@class='card-body card-block']/div[1]/div/span[2]")).getText();
		 System.out.println(act);
		 driver.findElement(By.xpath("//a[@class='navbar-brand']/img[@alt='Logo']")).click();
		}
		
		@Given("^I am on Transfer page3$")
		public void i_am_on_Transfer_page3() throws Throwable {
			driver.findElement(By.xpath("//a[@class='navbar-brand']/img[@alt='Logo']")).click();
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//a/i[@class='menu-icon fa fa-random']")).click();
		    driver.findElement(By.xpath("//a[contains(text(), 'Between Accounts')]")).click();
		    
		}

		@Given("^enter the transfer money as zero and click on submit button$")
		public void enter_the_transfer_money_as_zero_and_click_on_submit_button(DataTable Transdetials) throws Throwable {
			List<Map<String,String>> data = Transdetials.asMaps(String.class,String.class);
			driver.findElement(By.id("amount")).sendKeys(data.get(0).get("Transfer Money"));
			driver.findElement(By.xpath("//div[@class='card-footer']/button[1]")).click();
		}
		
		@Then("^verify the error message\\(Please match the format requested\\)$")
		public void verify_the_error_message_Please_match_the_format_requested() throws Throwable {
			String Error1 = driver.findElement(By.xpath("//span[contains(text(), 'The transfer amount ($0.00) must be greater than $0.00')]")).getText();
			Assert.assertEquals("The transfer amount ($0.00) must be greater than $0.00", Error1);
			
		}
		
		@Given("^I am on Transfer page4$")
		public void i_am_on_Transfer_page4() throws Throwable {
			driver.findElement(By.xpath("//a[@class='navbar-brand']/img[@alt='Logo']")).click();
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//a/i[@class='menu-icon fa fa-random']")).click();
		    driver.findElement(By.xpath("//a[contains(text(), 'Between Accounts')]")).click();
		}
	
		@Given("^I select the FROM and TO Account as same from drop down$")
		public void i_select_the_FROM_and_TO_Account_as_same_from_drop_down(DataTable userdetials) throws Throwable {
			List<Map<String,String>> data = userdetials.asMaps(String.class,String.class);
			driver.findElement(By.id("fromAccount")).sendKeys(data.get(0).get("FROM"));
		    driver.findElement(By.id("toAccount")).sendKeys(data.get(0).get("TO"));
		}
		
		@Given("^enter the transfer money for same account and click on submit button$")
		public void enter_the_transfer_money_for_same_account_and_click_on_submit_button(DataTable arg1) throws Throwable {
			List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
			driver.findElement(By.id("amount")).sendKeys(data.get(0).get("Transfer Money"));
			driver.findElement(By.xpath("//div[@class='card-footer']/button[1]")).click();
		}

		
		@Then("^verify the error message\\(Can not transfer from and to the same account\\)\\.$")
		public void verify_the_error_message_Can_not_transfer_from_and_to_the_same_account() throws Throwable {
		    String Error2 = driver.findElement(By.xpath("//span[contains(text(), 'Can not trasnsfer from and to the same account.')]")).getText();
		    Assert.assertEquals("Can not trasnsfer from and to the same account.", Error2);
		    driver.findElement(By.xpath("//a[@class='navbar-brand']/img[@alt='Logo']")).click();
		    driver.quit();
		}


}
