package utils;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "." },  
        strict = true, 
        glue = { "steps" }, 
        plugin = { 
                "pretty",
                "json:target/cucumber-html-report/cucumber.json", 
                "html:target/cucumber-html-report",
                "rerun:src/test/resources/features/rerun.txt"}
      )
public class RunTest {
}
