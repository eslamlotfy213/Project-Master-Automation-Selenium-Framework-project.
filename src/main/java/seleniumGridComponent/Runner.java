package seleniumGridComponent;

import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Runner  extends GridBaseTest{

    /*
   //D:\Selenium4\Selenuim_Framework_Design\src\main\java\Grid
    hub: java -jar selenium-server-4.15.0.jar  hub
    hub: java -jar selenium-server-4.15.0.jar node
    node: java -jar selenium-server-4.15.0.jar node --detect-drivers true
     */





    @Test
    public void HomePageCheck() throws MalformedURLException {

         driver.manage().window().maximize();
         driver.get("https://www.google.com");
     }











}
