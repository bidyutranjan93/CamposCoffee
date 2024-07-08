package Pages;

import TestBase.WebTestBase;
import Util.WebDriverUtil;
import Util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends WebTestBase {

    @FindBy(xpath = "//a[text()='Click here']")
    WebElement registerLink;

    @FindBy(xpath = "//h2[text()='Register']")
    WebElement registerPageText;

    @FindBy(id = "reg_email")
    WebElement emailUserNameTextBox;

    @FindBy(id = "reg_password")
    WebElement passwordTextBox;

    @FindBy(name = "register")
    WebElement registerBtn;

    @FindBy(xpath = "//strong[text()='Error:']")
    WebElement accountAlreadyExist;

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }
    public void setRegisterData(String userName , String password) {
        WebElementUtil.sendKeysOnElement(emailUserNameTextBox , userName);
        WebElementUtil.sendKeysOnElement(passwordTextBox , password);

        WebDriverUtil.waitElementUntilClickable(registerBtn);

    }

    public void clickOnRegisterLink(){
        WebElementUtil.clickOnElement(registerLink);
    }
    public String getTextOfRegisterPage(){
        return WebElementUtil.getTextOfElement(registerPageText);

    }
    public String getTextOfAccountAlreadyExistError(){
        return  WebElementUtil.getTextOfElement(accountAlreadyExist);
    }

}
