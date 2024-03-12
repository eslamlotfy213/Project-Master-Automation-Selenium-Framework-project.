package selenium.tests;

import Selenium.pages.*;
import testData.data.DataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import testData.data.DataReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    @Test(dataProvider = "getData", groups = {"EndToEndTesting","Regression"})
    public void Check_submitOrder(HashMap<String,String> input) {

        ProductsPage productsPage = landingPage.LoginToApplication(input.get("email"), input.get("password"));
        productsPage.addProductToCart(input.get("product"));

        CartPage cartPage = productsPage.goToCartPage();
        Boolean ismatched = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(ismatched);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.setCountry("Egy");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String actualMessage = confirmationPage.getconfirmationMessage();
        OrderPage orderage = productsPage.goToOrderPage();
        Boolean ismatched2 = orderage.verifyOrderDisplay(input.get("product"));
        Assert.assertTrue(ismatched2);
    }




    @DataProvider
    public Object[][] getData() throws IOException
    {
        // create object from class
        DataReader dataReader = new DataReader();
        //call method getJsonDataToMa and assign method to List
        List<HashMap<String, String>> data=  dataReader.getJsonDataToMap();;
        return new Object[][]
                {
                        {data.get(0)}, {data.get(1)}
                };
    }

}
