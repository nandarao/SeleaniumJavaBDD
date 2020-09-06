package Java.stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Java.pageObjects.LoginPage;
import Java.reusableFunations.Action;
import Java.reusableFunations.Log;
import Java.reusableFunations.MethodsImplementation;
import Java.reusableFunations.UseWebDriverElements;
import Java.utilitys.ConfigScreenshot;
import Java.utilitys.ReadConfigFile;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	private WebDriver driver;
	private ReadConfigFile readConfigFile;
	private Log log = new Log(Test_Steps.class.getName());
	private UseWebDriverElements useWebDriverElements;
	public ConfigScreenshot screenShot;
	// private ReadWriteExcelData readExcelData;
	private LoginPage login;

	@Given("^launch the browser$")
	public void launch_the_browser() throws Throwable {
		readConfigFile = new ReadConfigFile();
		System.setProperty("webdriver.gecko.driver", this.readConfigFile.getFireFOXDriverPath());
		this.driver = new FirefoxDriver();
		this.useWebDriverElements = new MethodsImplementation(driver);
		this.screenShot = new ConfigScreenshot(this.driver);
		log.info("FireFox Browser Initiated");
	}

	@When("^Open login page with URL$")
	public void open_login_page_with_URL() throws Throwable {
		this.useWebDriverElements.useWebElement(null, null, Action.get, this.readConfigFile.getApplicationURL(),
				"URL entered");
		log.info("URL entered");

	}

	@Then("^verify login page header$")
	public void verify_login_page_header() throws Throwable {

		Assert.assertEquals(useWebDriverElements.useWebElement(null, null, Action.getTitle, null,
				"Login page title matching with expected"), "Your store. Login");
		this.screenShot.takeScreenshot("Pass_loginPage");
	}

	@Then("^Close browser$")
	public void close_browser() throws Throwable {
		this.driver.close();
		log.endTestCase(Test_Steps.class.getName());
	}

	@Given("^Launch the \"([^\"]*)\" browser$")
	public void launch_the_browser(String string) throws Throwable {

		this.readConfigFile = new ReadConfigFile();

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

	@When("^open login page with URL : \"([^\"]*)\"$")
	public void open_login_page_with_URL(String string) throws Throwable {
		this.useWebDriverElements.useWebElement(null, null, Action.get, string, "URL entered");
	}

	@When("^Enter UserID and Password as \"([^\"]*)\"  \"([^\"]*)\"$")
	public void enter_UserID_and_Password_as(String string, String string2) throws Throwable {
		this.login.enterUserName(string);
		this.login.enterPassword(string2);
		this.screenShot.takeScreenshot("Pass_loginPage");
	}

	@When("^Click Login Button$")
	public void click_Login_Button() throws Throwable {
		this.login.clickLogin();
	}

	@Then("^Page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String string) throws Throwable {
		Assert.assertEquals(useWebDriverElements.useWebElement(null, null, Action.getTitle, null,
				"Login page title matching with expected"), string);
		this.screenShot.takeScreenshot("Pass_loginPage");
	}

	@When("^Click on Logout link$")
	public void click_on_Logout_link() throws Throwable {
		this.login.clickLogout();
	}

	@Given("^User launch \"([^\"]*)\" Browser$")
	public void user_launch_Browser(String arg1) throws Throwable {
		System.out.println("User launch : " + arg1 + "Browser");
	}

	@Given("^User opens login page with URL \"([^\"]*)\"$")
	public void user_opens_login_page_with_URL(String arg1) throws Throwable {
		System.out.println("User opens login page with URL " + arg1);
	}

	@Given("^User Enter UserID and Password as \"([^\"]*)\"  \"([^\"]*)\"$")
	public void user_Enter_UserID_and_Password_as(String arg1, String arg2) throws Throwable {
		System.out.println("User Enter UserID and Password as " + arg1 + " : " + arg2);
	}

	@Given("^User Click Login Button$")
	public void user_Click_Login_Button() throws Throwable {
		System.out.println("User Click Login Button");
	}

	@Given("^Match Page title with \"([^\"]*)\"$")
	public void match_Page_title_with(String arg1) throws Throwable {
		System.out.println("Match Page title with " + arg1);
	}

	@Given("^User Click on Logout link$")
	public void user_Click_on_Logout_link() throws Throwable {
		System.out.println("User Click on Logout link");
	}

	@Given("^User Close browser$")
	public void user_Close_browser() throws Throwable {
		System.out.println("User Close browser");
	}

	@Given("^Launch the browser$")
	public void launch_the_browser(DataTable String) throws Throwable {
		List<List<String>> data = String.raw();
		this.readConfigFile = new ReadConfigFile();

		if (data.get(0).contains("FF")) {
			System.setProperty("webdriver.gecko.driver", this.readConfigFile.getFireFOXDriverPath());
			this.driver = new FirefoxDriver();
			log.info("FireFox Browser Initiated");
		}

		else if (data.get(0).contains("CR")) {
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

	@When("^Enter UserID and Password$")
	public void enter_UserID_and_Password(DataTable String) throws Throwable {
		List<List<String>> data = String.raw();
		this.login.enterUserName(data.get(0).get(0));
		this.login.enterPassword(data.get(0).get(1));
		this.screenShot.takeScreenshot("Pass_loginPage");
	}

	@Given("^Launch the browser of$")
	public void launch_the_browser_of(DataTable String) throws Throwable {
		String Value;
		// List<Map<String,String>> data = String.asMaps(String.class, String.class);
		// List<Map<String>> data = String.asMap(String.class);
		this.readConfigFile = new ReadConfigFile();
		for (Map<String, String> data : String.asMaps(String.class, String.class)) {
			if (data.get("BrowserType").contains("FF")) {
				System.setProperty("webdriver.gecko.driver", this.readConfigFile.getFireFOXDriverPath());
				this.driver = new FirefoxDriver();
				log.info("FireFox Browser Initiated");
			}

			else if (data.get("BrowserType").contains("CR")) {
				System.setProperty("webdriver.chrome.driver", this.readConfigFile.getChromeDriverPath());
				this.driver = new ChromeDriver();
				log.info("Chrome Browser Initiated");
			}

			this.driver.manage().timeouts().implicitlyWait(this.readConfigFile.getImplicitlyWait(), TimeUnit.SECONDS);
			// this.useWebDriverElements = new UseWebElement(driver);
			this.screenShot = new ConfigScreenshot(this.driver);
			this.login = new LoginPage(driver);
			this.useWebDriverElements = new MethodsImplementation(driver);
			this.useWebDriverElements.useWebElement(null, null, Action.get, data.get("URL"), "URL entered");
			this.login.enterUserName(data.get("UserID"));
			this.login.enterPassword(data.get("Password"));
			this.login.clickLogin();
			Value = useWebDriverElements.useWebElement(null, null, Action.getTitle, null,
					"Login page title matching with expected");
			Assert.assertEquals(Value, data.get("HomeTitle"));
			this.screenShot.takeScreenshot("Home_loginPage");
			this.login.clickLogout();
			Value = useWebDriverElements.useWebElement(null, null, Action.getTitle, null,
					"Login page title matching with expected");
			Assert.assertEquals(Value, data.get("LoginTitle"));
			this.screenShot.takeScreenshot("Pass_loginPage");
			this.driver.close();
		}

	}

	//
	// @When("^Enter UserID and Password as$")
	// public void enter_UserID_and_Password_as(DataTable String) throws Throwable {
	//// List<Map<String, String>>data = String.asMaps(String.class, String.class);
	//
	// for (Map<String, String> data : String.asMaps(String.class, String.class)) {
	// this.login.enterUserName(data.get("UserID"));
	// this.login.enterPassword(data.get("Password"));
	// this.login.clickLogin();
	// Assert.assertEquals(useWebDriverElements.useWebElement(null, null,
	// Action.getTitle, null,
	// "Login page title matching with expected"), data.get("HomeTitle"));
	// this.screenShot.takeScreenshot("Home_loginPage");
	//
	// Assert.assertEquals(useWebDriverElements.useWebElement(null, null,
	// Action.getTitle, null,
	// "Login page title matching with expected"), data.get("HomeTitle"));
	// this.screenShot.takeScreenshot("Pass_loginPage");
	// }
	//
	//
	// }

}
