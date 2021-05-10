package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/resources/Elearning/elearning.feature"}, glue={"stepDefinition"},
plugin={"html:testoutput/muni.html","junit:testoutput/muni.xml","json:testoutput/muni.json"})
public class Test_Runner extends AbstractTestNGCucumberTests{

}

