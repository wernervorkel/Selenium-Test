package Pages;

import org.openqa.selenium.By;
import Utils.common;

import static Tests.SeleniumTest.driver;

public class CheckRegistrationPage {
    public static String enter_manually_btn = "//*[@id=\"e2e-enterdetailsmanually\"]";

    public static void click_enter_manually(){
        common.waitForElementXpathToBEPresent(enter_manually_btn);
        driver.findElement(By.xpath(enter_manually_btn)).click();
    }
}
