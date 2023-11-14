package Grid;

import Selenium.pages.LandingPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GridBaseTest {


    public static WebDriver driver;

    @Parameters({"browserName"})
    @BeforeTest
    public WebDriver setDriver(@Optional String browserName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browserName.equals("chrome")){
            capabilities.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        }else if (browserName.equals("firefox")) {
            capabilities.setBrowserName("firefox");
        }else if (browserName.equalsIgnoreCase("MicrosoftEdge")) {
            capabilities.setBrowserName("MicrosoftEdge");
        }
        driver = new RemoteWebDriver(new URL("  http://192.168.8.188:4444"),capabilities);
        System.out.println("thread: "+ Thread.currentThread().getId());

        return driver;
    }




    @AfterTest
    public void close(){
        driver.close();

    }





    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        String screenshotPath = null;

        try {

            //take screenshot and save it in a file

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //copy the file to the required path

            File destinationFile = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");

            FileHandler.copy(sourceFile, destinationFile);

            String[] relativePath = destinationFile.toString().split("reports");

            screenshotPath = ".\\" + relativePath[1];

        } catch (Exception e) {

            System.out.println("Failure to take screenshot " + e);

        }

        return screenshotPath;

    }



}
