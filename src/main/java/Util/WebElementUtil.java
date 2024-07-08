package Util;

import TestBase.WebTestBase;
import org.openqa.selenium.WebElement;

public class WebElementUtil extends WebTestBase {

    public static void clickOnElement(WebElement element) {       // create generic method for all click element
        element.click();
    }
    public static void sendKeysOnElement(WebElement element,String text) {       // create generic method for all sendKey element
        element.sendKeys(text);
    }

    public static void clearOnElement(WebElement element) {       // create generic method for all clear element.clear();
    }
    public  static  void submitOnElement(WebElement element){
        element.submit();
    }

    public  static  String getTextOfElement(WebElement element) {           //for get text return type is string
        return element.getText();
    }

    public static void isEnabled (WebElement element){
        element.isEnabled();
    }
    public static boolean isDisplay(WebElement element){
        return element.isDisplayed();
    }
    public static void isSelected (WebElement element){
        element.isDisplayed();
    }
    public  static  String getTitleOfElement() {           //for get text return type is string
        return driver.getTitle();
    }

    public static void elementIsSelected(WebElement element) {
        element.isSelected();
    }

}
