package org.CucumberJavaSelAssign.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"org.CucumberJavaSelAssign.StepDefination"
		},
		monochrome = true,
		plugin = {"pretty",
				"json:target/cucumber-reports/cucumber.json"},
		tags = "@Serach_Scenario_1 or @Serach_Scenario_2"

		)

public class RunnerTest {

}
