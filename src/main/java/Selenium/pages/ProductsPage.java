package Selenium.pages;

import abstractioncomponent.AbstractionComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends AbstractionComponent {

  private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By products = By.cssSelector(".mb-3");
    private By productBy = By.cssSelector(".mb-3");
    private By addToCart = By.cssSelector(".card-body button:last-of-type");
    private  By toastMessage = By.cssSelector("#toast-container");
    private  By  animating = By.cssSelector(".ng-animating");


    public List<WebElement> getProductsList() {
        waitForElementToAppear(productBy);
        return driver.findElements(products);
    }


    private By viewProduct = By.cssSelector(".card-body button:first-of-type");


    public void addProductToCart(String productName) {
        for (int i = 0; i < getProductsList().size(); i++) {
            System.out.println(getProductsList().get(i).findElement(By.cssSelector("b")).getText());
            if (getProductsList().get(i).findElement(By.cssSelector("b")).getText().contains(productName)) {
                getProductsList().get(i).findElement(addToCart).click();
                break;
            }
        }

        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(animating);

    }



    public void viewProductToCart(String productName) throws InterruptedException {
        for (int i = 0; i < getProductsList().size(); i++)
        {
            if (getProductsList().get(i).findElement(By.cssSelector("b")).getText().contains(productName))
            {
                getProductsList().get(i).findElement(viewProduct).click();
                break;
            }
        }

    }







}