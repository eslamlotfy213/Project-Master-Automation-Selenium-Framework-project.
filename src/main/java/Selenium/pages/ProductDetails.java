package Selenium.pages;

import abstractionComponent.AbstractionComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetails extends AbstractionComponent {



    WebDriver driver;
    public ProductDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }


    private By productTitle =By.tagName("img");

    private By addToCartbutton = By.cssSelector("button[class*='primary']");



    public String getProductTitle()  {
        waitForElementToAppear(productTitle);
        return driver.findElement(productTitle).getText();
    }

    public void goToAddToCartPage(){
        driver.findElement(addToCartbutton).click();
    }

}
