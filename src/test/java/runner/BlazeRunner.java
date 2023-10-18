package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"features/Login.feature"},glue = {"step.definition"}
public class BlazeRunner extends AbstractTestNGCucumberTests {

}
