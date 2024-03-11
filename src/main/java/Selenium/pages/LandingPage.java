package Selenium.pages;
import abstractionComponent.AbstractionComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractionComponent {


   private WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        //driver comes from test after create LandingPage landingPageobj = new LandingPage(driver); //driver from tests
    }


     private By userEmail = By.id("userEmail");
     private By userPassword= By.id("userPassword");
     private By login = By.id("login");
     private By errorMessage = By.cssSelector("[class*='flyInOut']");



     public String getErrorMessage(){

         waitForElementToAppear(errorMessage);

         return  driver.findElement(errorMessage).getText();
     }


    public ProductsPage LoginToApplication(String useremail, String passWord)
    {
        driver.findElement((userEmail)).clear();
        driver.findElement((userEmail)).sendKeys(useremail);
        driver.findElement((userPassword)).clear();
        driver.findElement((userPassword)).sendKeys(passWord);


        driver.findElement(login).click();
        return new ProductsPage(driver);
    }


}
