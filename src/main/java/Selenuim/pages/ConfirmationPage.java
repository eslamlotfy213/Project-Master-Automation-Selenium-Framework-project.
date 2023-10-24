package Selenuim.pages;

import abstractioncomponent.AbstractionComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends AbstractionComponent {


    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By confirmationMessage = By.cssSelector(".hero-primary");




    public String getconfirmationMessage()
    {
     return driver.findElement(confirmationMessage).getText();
    }



}
