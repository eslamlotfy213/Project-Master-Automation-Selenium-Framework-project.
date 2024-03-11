package cucumberBDD.stepDefinition;

import Selenium.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import baseComponent.BaseTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;

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

    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {

        Assert.assertEquals(strArg1, landingPage.getErrorMessage());

    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot ....",new ByteArrayInputStream(screenshot));
        }
        driver.close();
    }


}
