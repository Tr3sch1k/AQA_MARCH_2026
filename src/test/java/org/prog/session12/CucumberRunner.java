package org.prog.session12;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "org.prog.session12.steps",
        features = "src/test/resources/features"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
