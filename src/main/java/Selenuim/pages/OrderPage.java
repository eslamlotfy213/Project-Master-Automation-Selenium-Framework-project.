package Selenuim.pages;

import abstractioncomponent.AbstractionComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage extends AbstractionComponent {


    WebDriver driver;
    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver  = driver;
    }

    private By TitleOrderSections = By.cssSelector("tr td:nth-child(3)");

    public List<WebElement> getOrderSectionsList()
    {

        return driver.findElements(TitleOrderSections);
    }


    public Boolean verifyOrderDisplay(String productName)
    {
        Boolean ismatched =  getOrderSectionsList().stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        return ismatched;
    }
}
