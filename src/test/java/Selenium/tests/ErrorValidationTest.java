package Selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcomponent.BaseTest;

import java.io.IOException;

public class ErrorValidationTest extends BaseTest {


    @Test(groups = {"ErrorValidation","Smoke"})
    public void Check_loginValidationWrongPassword() throws IOException
    {
        landingPage.LoginToApplication("dexcomnew98@gmail.com","User");
        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.",errorMessage);
    }

    @Test(groups = {"ErrorValidation","Smoke"})
    public void Check_loginValidationWrongEmail() throws IOException
    {
        landingPage.LoginToApplication("user@gmail.com","User123#");
        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.",errorMessage);
    }

    @Test(groups = {"ErrorValidation","Smoke"})
    public void Check_loginValidation() throws IOException
    {
        landingPage.LoginToApplication("user@gmail.com","User123#");
        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect",errorMessage);
    }




}
