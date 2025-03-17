package Pages;

import TestBase.WebTestBase;
import Util.WebDriverUtil;
import Util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebTestBase {

    @FindBy(id = "username")
    WebElement loginPageUserName;

    @FindBy(id="password")
    WebElement loginPasswordTextBox;

    @FindBy(xpath = "//strong[text()='ERROR']")
    WebElement errorMessage;

    @FindBy(xpath = "//input[@name='login']")
    WebElement clickOnLoginBtn;

    @FindBy(xpath = "//a[text()='Click here']")
    WebElement registerElement;

    public LoginPage(){           //to initialize to make the constructor
        PageFactory.initElements(driver,this);
    }


    public void clickOnTheRegister() {
        WebDriverUtil.waitElementUntilClickable(registerElement);
    }

    public void setLogin(String userName,String password){
        WebElementUtil.sendKeysOnElement(loginPageUserName,userName);
        WebElementUtil.sendKeysOnElement(loginPasswordTextBox,password);
        WebDriverUtil.waitElementUntilClickable(clickOnLoginBtn);

    }

    public String getTextOfErrorMessage(){
        return WebElementUtil.getTextOfElement(errorMessage);
    }
}
