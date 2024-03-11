package Selenium.pages;

import abstractionComponent.AbstractionComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends AbstractionComponent {


   private WebDriver driver;
    public CartPage(WebDriver driver){
         super(driver);
         this.driver = driver;
    }

    private By titleCartSections = By.cssSelector(".cartSection h3");
    private  By checkoutbutton = By.cssSelector(".totalRow button");




    public List<WebElement> getCartSectionsList()
    {
        return driver.findElements(titleCartSections);
    }

    public Boolean verifyProductDisplay(String productName)
    {
        Boolean ismatched =  getCartSectionsList().stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        return ismatched;
    }


    public CheckoutPage goToCheckout()
    {
        driver.findElement(checkoutbutton).click();
        return new CheckoutPage(driver);
    }


}