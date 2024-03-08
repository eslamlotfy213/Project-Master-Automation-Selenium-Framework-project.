package cucumber.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber->  TestNG, junit
// not deal all feature with testNG use special features
//AbstractTestNGCucumberTests to make TestNG  to be runner

@CucumberOptions(features="src/test/java/cucumber/features",glue="cucumber.stepDefinition",
        monochrome=true, tags = "@Regression", plugin= {"html:target/cucumber.html" ,"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{




}
