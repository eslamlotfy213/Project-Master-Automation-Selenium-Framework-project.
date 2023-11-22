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
        Assert.assertEquals(message,errorMessage);

    }



    @DataProvider
    public Object[][] getData() throws IOException {

        //his method get data from excel sheet
        //pass data to dataprovider
        GetDataFromExcelintoDatadriver getDataFromExcelintoDatadriver = new GetDataFromExcelintoDatadriver();
        return  getDataFromExcelintoDatadriver.getData("TestData2","src/main/java/resources/Data.xlsx");

    }



}








