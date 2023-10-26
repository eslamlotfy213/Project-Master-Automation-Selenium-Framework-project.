package Selenium.pages;

import abstractioncomponent.AbstractionComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckoutPage extends AbstractionComponent
{

    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }


    private  By Country =By.cssSelector("[placeholder='Select Country']");
    private  By action__submit = By.cssSelector(".action__submit");
    private  By SelectCountry =By.xpath("(//button[contains(@class,'ta-item')])[1]");
    private  By results= By.cssSelector(".ta-results");



    public  void setCountry(String countryName){
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(Country),countryName).build().perform();
        waitForElementToAppear(results);
        driver.findElement(SelectCountry).click();
    }

    public ConfirmationPage submitOrder(){
      driver.findElement(action__submit).click();
      return new ConfirmationPage(driver);
    }


}
