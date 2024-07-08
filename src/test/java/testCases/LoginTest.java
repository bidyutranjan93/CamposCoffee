package testCases;

import TestBase.WebTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;

public class LoginTest extends WebTestBase {

    HomePage homePage;                              // object initialize
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    LoginTest(){
        super();        // call parent class in the current class
    }

    @BeforeMethod
    public void preRequisite(){
        initialization();       // from parent page to initialize the current class
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(description = "Verify Login With Valid UserName And Valid Password")
    public void verifyLoginWithValidUserNameAndValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("userName"), prop.getProperty("password"));
        softAssert.assertEquals(myAccountPage.getMyAccountElement(), "MY ACCOUNT", "MY Account text should be matched");
        softAssert.assertAll();
    }

    @Test(description = "Verify Login With Invalid UserName And ValidPassword")
    public void verifyLoginWithInvalidUserNameAndValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("invalidUserName"), prop.getProperty("password"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR", "ERROR The username or password you entered is incorrect. Lost your password?");
        softAssert.assertAll();
    }

    @Test(description = "Verify Login With ValidUserName And InvalidPassword")
    public void verifyLoginWithValidUserNameAndInvalidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("userName"), prop.getProperty("invalidPassword"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR", "ERROR The username or password you entered is incorrect. Lost your password?");
        softAssert.assertAll();
    }

    @Test(description = "Verify Login With InvalidUserName And InvalidPassword")
    public void verifyLoginWithInvalidUserNameAndInvalidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("invalidUserName"), prop.getProperty("invalidPassword"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR:", "ERROR The username or password you entered is incorrect. Lost your password?");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
