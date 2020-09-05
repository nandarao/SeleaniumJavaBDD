package Java.stepDefinitioins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Java.pageObjects.LoginPage;
import Java.reusableFunations.Action;
import Java.reusableFunations.Log;
import Java.reusableFunations.MethodsImplementation;
import Java.reusableFunations.UseWebDriverElements;
import Java.utilitys.ConfigScreenshot;
import Java.utilitys.ReadConfigFile;
//import Java.utilitys.ReadWriteExcelData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoingTestSteps {

	private WebDriver driver;
	private ReadConfigFile readConfigFile;
	private Log log = new Log(LoingTestSteps.class.getName());
	private UseWebDriverElements useWebDriverElements;
	public ConfigScreenshot screenShot;
//	private ReadWriteExcelData readExcelData;
	private LoginPage login;

	//
	// public LoingTestSteps(WebDriver driver) {
	// this.driver = driver;
	// }

	@Given("launch the browser")
	public void launch_the_browser() {
		readConfigFile = new ReadConfigFile();
		System.setProperty("webdriver.gecko.driver", this.readConfigFile.getFireFOXDriverPath());
		this.driver = new FirefoxDriver();
		this.useWebDriverElements = new MethodsImplementation(this.driver);
		this.screenShot = new ConfigScreenshot(this.driver);
		log.info("FireFox Browser Initiated");
	}

	@When("Open login page with URL")
	public void open_login_page_with_url() {
		this.useWebDriverElements.useWebElement(null, null, Action.get, this.readConfigFile.getApplicationURL(),
				"URL entered");
		log.info("URL entered");
	}

	@Then("verify login page header")
	public void verify_login_page_header() {
		try {
			Assert.assertEquals(useWebDriverElements.useWebElement(null, null, Action.getTitle, null,
					"Login page title matching with expected"), "Your store. Login");
			this.screenShot.takeScreenshot("Pass_loginPage");
		}

		catch (Exception e) {
			log.error(e.getMessage());
			this.screenShot.takeScreenshot("Fail_loginPage");
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Then("Close browser")
	public void close_browser() {
		this.driver.close();
		log.endTestCase(LoingTestSteps.class.getName());
		// this.driver.quit();
	}

	@Given("Launch the {string} browser")
	public void launch_the_browser(String string) {

		this.readConfigFile = new ReadConfigFile();
//		this.readExcelData = new ReadWriteExcelData(this.readConfigFile.getTestDataPath());

		if (string.contains("FF")) {
			System.setProperty("webdriver.gecko.driver", this.readConfigFile.getFireFOXDriverPath());
			this.driver = new FirefoxDriver();
			log.info("FireFox Browser Initiated");
		}

		else if (string.contains("CC")) {
			System.setProperty("webdriver.chrome.driver", this.readConfigFile.getChromeDriverPath());
			this.driver = new ChromeDriver();
			log.info("Chrome Browser Initiated");
		}

		this.driver.manage().timeouts().implicitlyWait(this.readConfigFile.getImplicitlyWait(), TimeUnit.SECONDS);
		// this.useWebDriverElements = new UseWebElement(driver);
		this.screenShot = new ConfigScreenshot(this.driver);
		this.login = new LoginPage(driver);
		this.useWebDriverElements = new MethodsImplementation(driver);

	}

	@When("open login page with URL : {string}")
	public void open_login_page_with_url(String string) {
		this.useWebDriverElements.useWebElement(null, null, Action.get, string, "URL entered");
	}

	@When("Enter UserID as  {string} and  Password as {string}")
	public void enter_user_id_as_and_password_as(String string, String string2) {
		this.login.enterUserName(string);
		this.login.enterPassword(string2);
		this.screenShot.takeScreenshot("Pass_loginPage");
	}

	@When("Click Login Button")
	public void click_login_button() {
		this.login.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
		Assert.assertEquals(useWebDriverElements.useWebElement(null, null, Action.getTitle, null,
				"Login page title matching with expected"), string);
		this.screenShot.takeScreenshot("Pass_loginPage");
	}

	@When("Click on Logout link")
	public void click_on_logout_link() {
		this.login.clickLogout();
	}

	/*@Then("Close browser")
	public void close_browser() {
		this.driver.close();
		log.endTestCase(LoingTestSteps.class.getName());
	}*/

}
