package Pages;

import TestBase.WebTestBase;
import Util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivacyPage extends WebTestBase {

    @FindBy(xpath = "//a[text()='Privacy']")
    WebElement privacyPageTxt;

    public PrivacyPage(){
        PageFactory.initElements(driver,this);
    }
    public String getPrivacyPageTxt(){
        return WebElementUtil.getTextOfElement(privacyPageTxt);
    }
}
