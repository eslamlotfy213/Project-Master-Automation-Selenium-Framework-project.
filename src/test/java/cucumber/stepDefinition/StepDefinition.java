package cucumber.stepDefinition;

import Selenium.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testcomponent.BaseTest;

import java.io.IOException;
import java.util.List;

public class StepDefinition extends BaseTest {

    public LandingPage landingPage;
    public ProductsPage productsPage;
    public   CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;
    public OrderPage orderage;


    @Given("I landed on Ecommerce Page")
    public void i_landed_on_ecommerce_page() throws IOException {
           landingPage = launchApplication();
    }


    @Given("Logged in with username {string} and password {string}")
    public void logged_in_with_username_and_password(String username , String password){
        productsPage = landingPage.LoginToApplication(username, password);

    }
    @When("I add product {string} to Cart")
    public void i_add_product_to_cart(String productName) {
       // List<WebElement> products = productsPage.getProductsList();
        productsPage.addProductToCart(productName);
    }

    @When("Checkout {string} and submit the order")
    public void checkout_and_submit_the_order(String productName) {

        cartPage = productsPage.goToCartPage();
        Boolean ismatched = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(ismatched);
        checkoutPage = cartPage.goToCheckout();
        checkoutPage.setCountry("Egy");
        confirmationPage = checkoutPage.submitOrder();
    }


    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String string)
    {

        String actualMessage = confirmationPage.getconfirmationMessage();
        Assert.assertTrue(actualMessage.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {

        Assert.assertEquals(strArg1, landingPage.getErrorMessage());
        driver.close();
    }



}
