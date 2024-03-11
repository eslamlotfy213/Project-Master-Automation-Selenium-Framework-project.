//package SelenuimStandalone.pagesobjects;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import java.time.Duration;
//import java.util.List;
//
//public class Automation2 {
//
//    public static void main(String[] args) {
//
//
//        String productName="ZARA COAT 3";
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver= new ChromeDriver();
//        driver.manage().window().maximize();
//
//
//        //-----------------------Login page-----------------------------------------------//
//        driver.get("https://rahulshettyacademy.com/client");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////        driver.findElement(By.id("userEmail")).sendKeys("dexcomnew98@gmail.com");
////        driver.findElement(By.id("userPassword")).sendKeys("User123#");
////        driver.findElement(By.id("login")).click();
//        LandingPage landingPage = new LandingPage(driver);
//        landingPage.LoginToApplication("dexcomnew98@gmail.com","User123#");
//
//        //-----------------------allproducts page-----------------------------------------------//
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//        List<WebElement> allproducts = driver.findElements(By.cssSelector(".mb-3"));
//
//        for (int i = 0; i < allproducts.size(); i++)
//        {
//            System.out.println(allproducts.get(i).findElement(By.cssSelector("b")).getText());
//            if (allproducts.get(i).findElement(By.cssSelector("b")).getText().contains(productName))
//            {
//                allproducts.get(i).findElement(By.cssSelector(".card-body button:last-of-type")).click();
//                break;
//            }
//        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//
//
//        //-----------------------cart page-----------------------------------------------//
//        //div[class='cartSection removeWrap'] button:first-of-type
//        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//        Boolean ismached=  cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
//        Assert.assertTrue(ismached);
//        System.out.println(ismached);
//        driver.findElement(By.cssSelector(".totalRow button")).click();  //Click on checkout button//
//
//
//        //-----------------------order page-----------------------------------------------//
//
//        Actions actions = new Actions(driver);
//        actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"Egy").build().perform();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[1]")).click();
//        driver.findElement(By.cssSelector(".action__submit")).click();
//        //------------------------------thanks----------------------------------------------------
//        System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());
//        String actualMessage =driver.findElement(By.cssSelector(".hero-primary")).getText();
//         Assert.assertTrue(actualMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//
//
//
//         driver.quit();
//
//    }
//
//}
