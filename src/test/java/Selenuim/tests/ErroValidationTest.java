package Selenuim.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import testcomponent.BaseTest;

import java.io.IOException;

public class ErroValidationTest extends BaseTest {


    @Test(groups = {"ErrorValidation","Smoke"})
    public void loginValidationWrongPassword() throws IOException
    {
        landingPage.LoginToApplication("dexcomnew98@gmail.com","User");
        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.",errorMessage);
    }

    @Test(groups = {"ErrorValidation","Smoke"})
    public void loginValidationWrongEmail() throws IOException
    {
        landingPage.LoginToApplication("user@gmail.com","User123#");
        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.",errorMessage);
    }


    @Test(groups = {"ErrorValidation","Smoke"})
    public void loginValidation() throws IOException
    {
        landingPage.LoginToApplication("user@gmail.com","User123#");
        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect",errorMessage);
    }

}
