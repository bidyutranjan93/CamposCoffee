package Pages;

import TestBase.WebTestBase;
import Util.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends WebTestBase {

    @FindBy(xpath = "//a[@class='newsletter__close newsletter__trigger']")
    WebElement closeAd;

    @FindBy(xpath = "//a[@class='user-controls__ul__li__a']")
    WebElement loginAndRegister;

    @FindBy(xpath = "//a[text()='Café Finder']")
    WebElement cafeFinderBtn;

    @FindBy(xpath = "//h6[text()='Campos Coffee Cafe Finder']")
    WebElement findCamposCafeNear;

    @FindBy(id = "gform_confirmation_message_13")
    WebElement discountMail;

    @FindBy(id = "input_13_1")
    WebElement discountEmailIdTextBox;

    @FindBy(id = "gform_submit_button_13")
    WebElement discountSubmitBtn;

    @FindBy(xpath = "//a[text()='Privacy' and @class='footer__legal-menu__li__a']")
    WebElement privacyBtn;

    @FindBy(xpath = "//a[text()='Shop']")
    WebElement shopElementLink;

    @FindBy(xpath = "(//a[text()='Capsules'])[1]")
    WebElement capsule;


    @FindBy(xpath = "//h2[text()='Explore the range']")
    WebElement textOfTheExploreTheRange;

    @FindBy(xpath = "(//img[@alt='Campos Superior Blend'])[1]")
    WebElement productCamposSuperiorBlend;


    @FindBy(xpath = "//div[@class='header__logo-container']")
    WebElement logoElement;


    public HomePage() {        // for initialize the class make constructor
        PageFactory.initElements(driver, this);
    }

    public void closeFirstAd() {
        //  closeAd.click();    ---------------apart from we use the explicit wait
        WebDriverUtil.waitElementUntilClickable(closeAd);
    }

    public void clickOnLoginAndRegister() {
        WebDriverUtil.waitElementUntilClickable(loginAndRegister);
    }

    public void clickOnCafeFinderBtn() {
        WebDriverUtil.waitElementUntilClickable(cafeFinderBtn);         //  -------------use the action class
    }
    public boolean isDisplayCafeFinderText(){
        return WebElementUtil.isDisplay(findCamposCafeNear);

    }

    public void clickOnTheProduct() {
        WebDriverUtil.waitElementUntilClickable(productCamposSuperiorBlend);
    }

    public void setDiscountMail(String discountMail) {
        WebElementUtil.sendKeysOnElement(discountEmailIdTextBox, discountMail);
        WebDriverUtil.waitElementUntilClickable(discountSubmitBtn);

    }

    public String getDiscountMail() {
        return WebElementUtil.getTextOfElement(discountMail);
    }

    public void checkPrivacyBtn() {
        WebDriverUtil.waitElementUntilClickable(privacyBtn);
    }


    public void actionOnTheShopBtn() {
        ActionUtil.moveToElementCommand(shopElementLink);
    }

    public void allDropDwn() {
        // LoopsUtil.selectOptionFromMultipleOptions(allHiddenOption, capsule);
        WebDriverUtil.waitElementUntilClickable(capsule);
    }

    public void ScrollToTheText() {
        JavaScriptExecutorUtil.scrollByElement(textOfTheExploreTheRange);
    }

    public String getScrollToTheText() {
        return WebElementUtil.getTextOfElement(textOfTheExploreTheRange);
    }


    public void logoOfBrand() {
        ActionUtil.moveToElementCommand(logoElement);
    }

    public  boolean logoOfBrandIsDisplay() {
        return WebElementUtil.isDisplay(logoElement);
    }

    public void clickOnShopLink(){
        WebDriverUtil.waitElementUntilClickable(shopElementLink);

    }

}
