package Pages;

import TestBase.WebTestBase;
import Util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscoverMorePage extends WebTestBase {

    @FindBy(xpath = "//a[text()='CAFE FINDER']")
    WebElement discoverMore;

    public DiscoverMorePage() {
        PageFactory.initElements(driver, this);
    }

    public String getDiscoverMorePageTitle(){
        return WebElementUtil.getTextOfElement(discoverMore);

    }public void  getDiscoverMorePageDisplay(){
        WebElementUtil.isDisplay(discoverMore);

    }
}
