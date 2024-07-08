package Pages;

import TestBase.WebTestBase;
import Util.DropDownUtil;
import Util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrewGuidePage extends WebTestBase {

    @FindBy(xpath = "//div[@class='filter_item filter_item--active']")
    WebElement drpOfBrewGuidElement;

    @FindBy(css = "button[name='button']")
    WebElement clickOnFindElement;

    public BrewGuidePage() {
        PageFactory.initElements(driver, this);
    }

    public void getDrpOfBrewGuidSelectNews(){
        WebDriverUtil.waitElementUntilClickable(drpOfBrewGuidElement);
        DropDownUtil.selectDropDownByVisibleText(drpOfBrewGuidElement,"News");
    }
    public void getClickOnFindBtn(){
        WebDriverUtil.waitElementUntilClickable(clickOnFindElement);

    }
}
