package Util;

import TestBase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil extends WebTestBase {

    public static Select select;

    public static void dropdownElement(int index , WebElement element){
        select =new Select(element);
        select.selectByIndex(index);
    }
    public static void dropDownElement(String visibleText , WebElement element){
        select=new Select(element);
        select.selectByVisibleText(visibleText);
    }
    public static void dropDownByValue(String value , WebElement element){
        select=new Select(element);
        select.selectByValue(value);
    }
    public static void dropDownVisibleText( String visibleWithText , WebElement element){
        select=new Select(element);
        select.deselectByVisibleText(visibleWithText);
    }

    public static void selectDropDownByVisibleText(WebElement element,String visibleText){
        Select dropdown=new Select(element);
        dropdown.selectByVisibleText(visibleText);

    }
}
