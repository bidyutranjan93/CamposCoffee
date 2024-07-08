package Pages;

import TestBase.WebTestBase;
import Util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends WebTestBase {

    @FindBy(xpath="//a[text()='Browse products']")
    WebElement orderElement;

    public OrderPage(){
        PageFactory.initElements(driver,this);
    }
    public  String  getOrderElement() {
        return WebElementUtil.getTextOfElement(orderElement);
    }
}
