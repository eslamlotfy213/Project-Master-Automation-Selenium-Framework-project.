package abstractioncomponent;

import Selenium.pages.CartPage;
import Selenium.pages.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
