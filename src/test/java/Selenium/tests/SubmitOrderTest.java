package Selenium.tests;

import Selenium.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcomponent.BaseTest;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {

    @Test(dataProvider = "getData", groups = {"EndToEndTesting","Regression"})
    public void Check_submitOrder(String email, String password, String productName) throws IOException {

        ProductsPage productsPage = landingPage.LoginToApplication(email, password);
        productsPage.addProductToCart(productName);

        CartPage cartPage = productsPage.goToCartPage();
        Boolean ismatched = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(ismatched);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.setCountry("Egy");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String actualMessage = confirmationPage.getconfirmationMessage();
        OrderPage orderage = productsPage.goToOrderPage();
        Boolean ismatched2 = orderage.verifyOrderDisplay(productName);
        Assert.assertTrue(ismatched2);
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
