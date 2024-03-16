package cucumberBDD.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//cucumber->  TestNG, junit
// not deal all feature with testNG use special features
//AbstractTestNGCucumberTests to make TestNG  to be runner

@CucumberOptions(features="src/test/java/cucumberBDD/features",
        glue="cucumberBDD.stepDefinition",
        monochrome=true,
        tags = "@Regression",
        plugin= {
        "html:target/cucumberFolder/cucumber.html" ,
        "pretty","json:target/cucumberFolder/report.json",
        "pretty","json:target/cucumberFolder/report.xml",
         "timeline:target/cucumber",
        "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{






    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }


}
