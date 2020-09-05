package Java.stepDefinitioins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Java.reusableFunations.Action;
import Java.reusableFunations.Log;
import Java.reusableFunations.MethodsImplementation;
import Java.reusableFunations.UseWebDriverElements;
import Java.utilitys.ConfigScreenshot;
import Java.utilitys.ReadConfigFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoingTestSteps {

	private WebDriver driver;
	private ReadConfigFile readConfigFile;
	private Log log = new Log(LoingTestSteps.class.getName());
	private UseWebDriverElements useWebDriverElements;
	public ConfigScreenshot screenShot;
	
//	
//	public LoingTestSteps(WebDriver driver) {
//		this.driver = driver;
//	}

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

	@Then("close Browser")
	public void close_browser() {
		this.driver.close();
		log.endTestCase(LoingTestSteps.class.getName());
//		this.driver.quit();
	}

}
