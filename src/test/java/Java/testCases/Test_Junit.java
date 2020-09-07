package Java.testCases;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\java\\Java\\Feature"}
		,glue= {"Java.stepDefinition"}
//		,dryRun = true
		,monochrome = false
		,tags= {"@smokeTest"}		
		)
public class Test_Junit  {

}
