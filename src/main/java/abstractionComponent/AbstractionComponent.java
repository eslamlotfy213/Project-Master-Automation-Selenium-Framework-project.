package abstractionComponent;

import Selenium.pages.CartPage;
import Selenium.pages.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class AbstractionComponent {

    /*
    This class contains all common methods
    use it by extend child class from this parent
    use it also by super(driver);
    driver comes from testcase
    driver pass to super(driver);
    then create a constructor inside parent
     */


     private WebDriver driver;
     private By cartPageLink = By.cssSelector("[routerlink*='cart']");

     private By myOrderPageLink = By.cssSelector("[routerlink*='myorders']");


     public AbstractionComponent(WebDriver driver)
     {
         this.driver = driver;
     }



     public  void fluentWaitForElement(By findBy){

         // Waiting 30 seconds for an element to be present on the page, checking
         // for its presence once every 5 seconds.
         Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                 .withTimeout(Duration.ofSeconds(30L))
                 .pollingEvery(Duration.ofSeconds(5L))
                 .ignoring(NoSuchElementException.class);
         WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
             public WebElement apply(WebDriver driver) {
             if (driver.findElement(findBy).isDisplayed())
                 {
                     return driver.findElement(findBy);
                 }else{
                 return  null;
              }
            }
         });
     }


    public void waitForElementToAppear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }


    public void waitForWebElementToAppear(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForElementToDisappear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));
    }

    public void waitForWebElementToDisappear(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(findBy));
    }


    public CartPage goToCartPage(){
        waitForElementToAppear(cartPageLink);
        driver.findElement(cartPageLink).click();
        return new CartPage(driver);
    }

    public OrderPage goToOrderPage(){
        waitForElementToAppear(myOrderPageLink);
        driver.findElement(myOrderPageLink).click();
        return new OrderPage(driver);
    }



}
