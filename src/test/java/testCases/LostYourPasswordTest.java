package testCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.LostYourPasswordPage;
import Pages.MyAccountPage;
import TestBase.WebTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LostYourPasswordTest extends WebTestBase {

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LostYourPasswordPage lostYourPasswordPage;

    LostYourPasswordTest(){
        super();
    }
    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage=new HomePage();
        loginPage=new LoginPage();
        myAccountPage=new MyAccountPage();
        lostYourPasswordPage= new LostYourPasswordPage();
    }
    @Test(description = "Verify lost your password link is clickable")
    public void verifyLostYourPasswordLink(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        lostYourPasswordPage.clickOnLostYourPwdLink();
        softAssert.assertEquals(lostYourPasswordPage.getTextOfLostPwdPage(),"LOST YOUR\n" +
                "PASSWORD?", "user landed to the lost your page");
        softAssert.assertAll();
    }
    @Test(description = "Verify reset Password link with valid username ")
    public void verifyResetPasswordLinkWithValidUserName(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        lostYourPasswordPage.clickOnLostYourPwdLink();
        lostYourPasswordPage.setLogin(prop.getProperty("userName"));
        softAssert.assertEquals(lostYourPasswordPage.getTextThankYouOfResetPassword(),"THANK YOU", "ThankYou message should be dispaly");
        softAssert.assertAll();
    }

    @Test(description = "Verify reset Password link with Invalid username ")       // but this was a bug from the backend which carries invalid mail id.
    public void verifyResetPasswordLinkWithInValidUserName(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        lostYourPasswordPage.clickOnLostYourPwdLink();
        lostYourPasswordPage.setLogin(prop.getProperty("invalidUserName"));
        softAssert.assertEquals(lostYourPasswordPage.getTextThankYouOfResetPassword(),"THANK YOU", "Password reset email has been sent");
        softAssert.assertAll();
    }

    @Test(description = "Verify reset Password functionality without username")
    public void verifyResetPasswordFunctionalityWithoutUsername(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        lostYourPasswordPage.clickOnLostYourPwdLink();
        lostYourPasswordPage.setLogin(prop.getProperty("withoutUserName"));
        softAssert.assertEquals(lostYourPasswordPage.getTextOfLostPwdPage(),"LOST YOUR\n" +
                "PASSWORD?", "Error message should be display and user landed to same page");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
