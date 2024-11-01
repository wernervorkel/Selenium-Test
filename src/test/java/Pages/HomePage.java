package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import Utils.common;

import static Tests.SeleniumTest.driver;

public class HomePage {
    public static String consent_banner = "//*[@id=\"onetrust-banner-sdk\"]";
    public static String accept_consent_btn = "//*[@id=\"onetrust-accept-btn-handler\"]";
    public static String vehicle_reg_textbox = "//*[@id=\"vehicleReg\"]";
    public static String mileage_textbox = "//*[@id=\"Mileage\"]";
    public static String valuation_btn = "//*[@id=\"btn-go\"]";

    public static void input_vehicle_reg(String args){
        common.waitForElementXpathToBEPresent(vehicle_reg_textbox);
        driver.findElement(By.xpath(vehicle_reg_textbox)).sendKeys(args);
    }

    public static void input_mileage(String args){
        common.waitForElementXpathToBEPresent(mileage_textbox);
        driver.findElement(By.xpath(mileage_textbox)).sendKeys(args);
    }

    public static void click_valuation(){
        common.waitForElementXpathToBEPresent(valuation_btn);
        driver.findElement(By.xpath(valuation_btn)).click();
    }

    public static void consent_banner_close(){
        common.waitForElementXpathToBEPresent(consent_banner);
        if(driver.findElement(By.xpath(consent_banner)).isDisplayed()){
            driver.findElement(By.xpath(accept_consent_btn)).click();
        }
    }

    public static void validate_vehicle_reg_textbox(){
        common.waitForElementXpathToBEPresent(vehicle_reg_textbox);

        Assert.assertTrue(driver.findElement(By.xpath(vehicle_reg_textbox)).isDisplayed());
    }

    public static void validate_mileage_textbox(){
        common.waitForElementXpathToBEPresent(mileage_textbox);

        Assert.assertTrue(driver.findElement(By.xpath(mileage_textbox)).isDisplayed());
    }

    public static void validate_valuation_btn(){
        common.waitForElementXpathToBEPresent(valuation_btn);

        Assert.assertTrue(driver.findElement(By.xpath(valuation_btn)).isDisplayed());
    }
}
