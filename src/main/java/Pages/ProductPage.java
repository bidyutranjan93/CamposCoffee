package Pages;

import TestBase.WebTestBase;
import Util.DropDownUtil;
import Util.WebDriverUtil;
import Util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends WebTestBase {

    @FindBy(xpath = "//select[@class='pa_weight']")
    WebElement bagSizeDrpD;

    @FindBy(xpath = "//div[text()='Whole Beans']")
    WebElement wholeBeanElement;
    @FindBy(xpath = "//div[text()='Once off']")
    WebElement onceOffElement;

    @FindBy(xpath = "//span[@class='price']")
    WebElement addToCartElement;


    @FindBy(xpath = "//a[text()='Checkout']")
    WebElement CheckOutElement;

    @FindBy(xpath = "//h3[text()='Your order'and @class='cart__heading']")
    WebElement textOfOrder;
    public ProductPage() {        // for initialize the class make constructor
        PageFactory.initElements(driver, this);
    }

    public void selectDropDn(){
        WebDriverUtil.waitElementUntilClickable(bagSizeDrpD);
        DropDownUtil.selectDropDownByVisibleText(bagSizeDrpD,"500g");


    }
    public void clickOnGrind(){
        WebDriverUtil.waitElementUntilClickable(wholeBeanElement);
    }
    public void clickOnFrequency(){
        WebDriverUtil.waitElementUntilClickable(onceOffElement);
    }
    public void clickOnSubmitBtn(){
        WebDriverUtil.waitElementUntilClickable(addToCartElement);
    }

    public void clickOnCheckout(){
        WebDriverUtil.waitElementUntilClickable(CheckOutElement);
    }
    public String getTextOfOrder(){
        return  WebElementUtil.getTextOfElement(textOfOrder);
    }
}
