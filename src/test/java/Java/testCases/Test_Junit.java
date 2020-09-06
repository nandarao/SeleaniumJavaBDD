package Java.testCases;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\java\\Feature"}
		,glue= {"Java.stepDefinition"}
//		,dryRun = true
		,monochrome = true
		)
public class Test_Junit  {

}
