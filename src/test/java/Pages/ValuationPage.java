package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import Utils.common;

import static Tests.SeleniumTest.driver;

public class ValuationPage {
    public static String amount_label = "//*/section[2]/div/div[1]/div[1]/div[1]/div/div[1]/div/div";

    public static void validate_amount_range(int value){
        common.waitForElementXpathToBEPresent(amount_label);
        String actualValue = driver.findElement(By.xpath(amount_label)).getText();

        Assert.assertTrue(driver.findElement(By.xpath(amount_label)).isDisplayed());
        Assert.assertTrue(value <= Integer.parseInt(actualValue.replace("£", "").replace(",", "")), "Test Failed: Value is less than " + value);
    }
}
