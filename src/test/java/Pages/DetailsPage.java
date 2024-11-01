package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import Utils.common;

import static Tests.SeleniumTest.driver;

public class DetailsPage {
    public static String email_textbox = "//*[@id=\"EmailAddress\"]";
    public static String postcode_textbox = "//*[@id=\"Postcode\"]";
    public static String tel_textbox = "//*[@id=\"TelephoneNumber\"]";
    public static String valuation_btn = "//*[@id=\"advance-btn\"]";
    public static String registration_label = "//*/div[3]/div/vehicle-details/div[3]/div[1][@id=\"vehicleImage\"]/div[2]";
    public static String manufacturer_label = "//*/div[3]/div/vehicle-details/div[3]/div[2]/div[1]/div[text()='Manufacturer:']/following-sibling::div";
    public static String model_label = "//*/div[3]/div/vehicle-details/div[3]/div[2]/div[2]/div[text()='Model:']/following-sibling::div";
    public static String year_label = "//*/div[3]/div/vehicle-details/div[3]/div[2]/div[3]/div[text()='Year:']/following-sibling::div";

    public static String email = "a@aol.com";
    public static String postcode = "E20 1EJ";
    public static String telephone = "07388111111";


    public static void input_email(){
        common.waitForElementXpathToBEPresent(email_textbox);
        driver.findElement(By.xpath(email_textbox)).sendKeys(email);
    }

    public static void input_postcode(){
        common.waitForElementXpathToBEPresent(postcode_textbox);
        driver.findElement(By.xpath(postcode_textbox)).sendKeys(postcode);
    }

    public static void input_telephone(){
        common.waitForElementXpathToBEPresent(tel_textbox);
        driver.findElement(By.xpath(tel_textbox)).sendKeys(telephone);
    }

    public static void click_valuation(){
        common.waitForElementXpathToBEPresent(valuation_btn);
        driver.findElement(By.xpath(valuation_btn)).click();
    }

    public static void validate_email_textbox(){
        common.waitForElementXpathToBEPresent(email_textbox);

        Assert.assertTrue(driver.findElement(By.xpath(email_textbox)).isDisplayed());
    }

    public static void validate_postcode_textbox(){
        common.waitForElementXpathToBEPresent(postcode_textbox);

        Assert.assertTrue(driver.findElement(By.xpath(postcode_textbox)).isDisplayed());
    }

    public static void validate_telephone_textbox(){
        common.waitForElementXpathToBEPresent(tel_textbox);

        Assert.assertTrue(driver.findElement(By.xpath(tel_textbox)).isDisplayed());
    }

    public static void validate_valuation_btn(){
        common.waitForElementXpathToBEPresent(valuation_btn);

        Assert.assertTrue(driver.findElement(By.xpath(valuation_btn)).isDisplayed());
    }

    public static void validate_registration_data(String reg){
        common.waitForElementXpathToBEPresent(registration_label);

        Assert.assertTrue(driver.findElement(By.xpath(registration_label)).isDisplayed());
        Assert.assertEquals(reg, driver.findElement(By.xpath(registration_label)).getText());

    }

    public static void validate_manufacturer_data(String manufacturer){
        common.waitForElementXpathToBEPresent(manufacturer_label);

        Assert.assertTrue(driver.findElement(By.xpath(manufacturer_label)).isDisplayed());
        Assert.assertEquals(manufacturer, driver.findElement(By.xpath(manufacturer_label)).getText());

    }

    public static void validate_model_data(String model){
        common.waitForElementXpathToBEPresent(model_label);

        Assert.assertTrue(driver.findElement(By.xpath(model_label)).isDisplayed());
        Assert.assertEquals(model, driver.findElement(By.xpath(model_label)).getText());
    }

    public static void validate_year_data(String year){
        common.waitForElementXpathToBEPresent(year_label);

        Assert.assertTrue(driver.findElement(By.xpath(year_label)).isDisplayed());
        Assert.assertEquals(year, driver.findElement(By.xpath(year_label)).getText());
    }
}
