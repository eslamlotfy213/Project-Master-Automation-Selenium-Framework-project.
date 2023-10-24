package Selenuim.tests;

import Selenuim.pages.*;
import Selenuim.pages.OrderPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcomponent.BaseTest;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {

    @Test(dataProvider = "getData"
            , groups = {"EndToEndTesting","Regression"})
    public void submitOrder(String email, String password, String productName) throws IOException {

        ProductsPage productsPage = landingPage.LoginToApplication(email, password);
        productsPage.addProductToCart(productName);
        CartPage cartPage = productsPage.goToCartPage();
        Boolean ismatched = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(ismatched);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.setCountry("Egy");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String actualMessage = confirmationPage.getconfirmationMessage();
        Assert.assertTrue(actualMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {
        String productName = "ZARA COAT 3";
        ProductsPage productsPage = landingPage.LoginToApplication("dexcomnew98@gmail.com", "User123#");
        OrderPage orderage = productsPage.goToOrderPage();
        Boolean ismatched = orderage.verifyOrderDisplay(productName);
        Assert.assertTrue(ismatched);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]
                {
                        {"dexcomnew98@gmail.com", "User123#" , "ZARA COAT 3"},
                        {"postman2024@gmail.com", "User123#","IPHONE 13 PRO"}
                };
    }
}
