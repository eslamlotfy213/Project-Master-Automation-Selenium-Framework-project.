package Selenium.tests;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.GetDataFromExcelintoDatadriver;
import testcomponent.BaseTest;
import testcomponent.Retry;


public class SP1_Login_VerifyLoginTest extends BaseTest {



    // 1.test it before retryAnalyzer = Retry.class
    // 2.test it after retryAnalyzer = Retry.class


    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "getData",retryAnalyzer = Retry.class)
    public void Check_SP1_Login_VerifyLogin(String username, String password , String message) {

        landingPage.LoginToApplication(username, password);
        String errorMessage = landingPage.getErrorMessage();
        System.out.println(errorMessage);
        Assert.assertEquals(message,errorMessage);
    }




















    @DataProvider
    public Object[][] getData() {
        GetDataFromExcelintoDatadriver getDataFromExcelintoDatadriver = new GetDataFromExcelintoDatadriver();
        return getDataFromExcelintoDatadriver.getData("TestData2", "src/main/java/resources/Data.xlsx");
    }



}








