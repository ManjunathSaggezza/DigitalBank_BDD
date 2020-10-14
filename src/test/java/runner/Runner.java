package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features", tags="@Login, @Transfer"
,glue= {"seleniumgluecode"},
dryRun= false,
format = {"pretty", "html:target/cucumber"}
)

public class Runner {


}
