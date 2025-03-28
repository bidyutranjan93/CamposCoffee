package Pages;

import TestBase.WebTestBase;
import Util.WebDriverUtil;
import Util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends WebTestBase {

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountElement;

    @FindBy(xpath = "//a[text()='Orders']")
    WebElement orderInToolTip;

    @FindBy(xpath = "//a[text()='Browse products']")
    WebElement textBrowseProduct;

    @FindBy(xpath = "//a[text()='Browse products']")
    WebElement browseProductLink;

    @FindBy(id = "rememberme")
    WebElement rememberMeCheckbox;

    @FindBy(xpath = "//h2[text()='Log in']")
    WebElement loginText;

    public MyAccountPage(){
        PageFactory.initElements(driver, this);
    }

    public void rememberMeBoxIsEnabled(){
        WebElementUtil.elementIsSelected(rememberMeCheckbox);
    }
    public String getTextOfLoginPage(){
        return WebElementUtil.getTextOfElement(loginText);
    }
    public String getMyAccountElement(){
        return WebElementUtil.getTextOfElement(myAccountElement);
    }

    public void clickOnOrdersInToolTip(){
        WebDriverUtil.waitElementUntilClickable(orderInToolTip);

    }
    public String getTextOrderLink(){
        WebDriverUtil.waitElementUntilClickable(orderInToolTip);
        return WebElementUtil.getTextOfElement(orderInToolTip);

    }
    public  void clickOnBrowseProductLink(){
        WebDriverUtil.waitElementUntilClickable(browseProductLink);
    }
    public String getTextBrowseProductLink(){
        return WebElementUtil.getTextOfElement(textBrowseProduct);
    }

}
