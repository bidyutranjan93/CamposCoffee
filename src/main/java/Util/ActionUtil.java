package Util;

import TestBase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionUtil extends WebTestBase {

    public static Actions actions;

    public static  void MoveToElement(WebElement element){
        actions=new Actions(driver);
        actions.moveToElement(element)
                .pause(Duration.ofSeconds(4))
                .perform();
    }

    public static void clickToElementCommand(WebElement element){
        Actions clickEle=new Actions(driver);
        clickEle.click(element);
    }

    public static void moveToElementCommand(WebElement element){
        Actions moveEle=new Actions(driver);
        moveEle.moveToElement(element);
    }


}
