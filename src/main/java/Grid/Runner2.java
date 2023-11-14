package Grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Runner2 extends GridBaseTest{

    /*
   //D:\Selenium4\Selenuim_Framework_Design\src\main\java\Grid
    hub: java -jar selenium-server-4.15.0.jar  hub
    hub: java -jar selenium-server-4.15.0.jar node
    node: java -jar selenium-server-4.15.0.jar node --detect-drivers true
     */






    @Test
    public void HomePageCheck2() throws MalformedURLException {

         driver.manage().window().maximize();
         driver.get("https://www.toolsqa.com");
     }






}
