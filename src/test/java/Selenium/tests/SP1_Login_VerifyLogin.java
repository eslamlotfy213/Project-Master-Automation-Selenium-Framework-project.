package Selenium.tests;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.GetDataFromExcelintoDatadriver;
import testcomponent.BaseTest;


import java.io.IOException;


public class SP1_Login_VerifyLogin extends BaseTest {

    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "getData")
    public void Check_SP1_Login_VerifyLogin(String username, String password , String message) throws IOException {

        landingPage.LoginToApplication(username, password);
        String errorMessage = landingPage.getErrorMessage();
        System.out.println(errorMessage);
        Assert.assertEquals(message,errorMessage);
    }



    @DataProvider
    public Object[][] getData() {
        GetDataFromExcelintoDatadriver getDataFromExcelintoDatadriver = new GetDataFromExcelintoDatadriver();
        try {
            return getDataFromExcelintoDatadriver.getData("TestData2", "src/main/java/resources/Data.xlsx");
        } catch (IOException e) {
            // Handle the exception (log, throw a custom exception, etc.)
            e.printStackTrace();
            return null; // or throw a custom exception
        }
    }



}








