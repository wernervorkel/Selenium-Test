package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import Utils.common;

import java.time.Duration;

import static Tests.SeleniumTest.driver;

public class ManualLookUpPage {
    public static String car_btn = "//*/div[1]/dynamic-form-question/div/div[1]/list-radio/div/div/label[1]";
    public static String manufacturer_dropdown = "Manufacturer";
    public static String model_dropdown = "Model";
    public static String fuel_type_dropdown = "FuelType";
    public static String reg_year_dropdown = "RegYear";
    public static String colour_dropdown = "Colour";
    public static String derivative_dropdown = "Derivative";
    public static String paint_type_bnt = "//*/div[7]/dynamic-form-question/div/div/list-radio/div/div/label[2]";
    public static String this_is_my_car_bnt = "//*[@id=\"confirm\"]";

    public static void click_car_btn() {
        common.waitForElementXpathToBEPresent(car_btn);
        driver.findElement(By.xpath(car_btn)).click();
    }

    public static void click_paint_btn() {
        common.waitForElementToBeClickable("xpath", paint_type_bnt);
        driver.findElement(By.xpath(paint_type_bnt)).click();
    }

    public static void click_this_is_my_car_btn() throws InterruptedException {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(this_is_my_car_bnt)));
        Thread.sleep(Duration.ofMillis(2000));
        driver.findElement(By.xpath(this_is_my_car_bnt)).click();
    }

    public static void manufacturer_select_dropdown() {
        common.waitForElementToBeClickable("id", manufacturer_dropdown);
        Select dropdown = new Select(driver.findElement(By.id(manufacturer_dropdown)));
        dropdown.selectByVisibleText("VOLKSWAGEN");
    }

    public static void model_select_dropdown() {
        common.waitForElementToBeClickable("id", model_dropdown);
        Select dropdown = new Select(driver.findElement(By.id(model_dropdown)));
        dropdown.selectByVisibleText("GOLF");
    }

    public static void fuel_type_select_dropdown() {
        common.waitForElementToBeClickable("id", fuel_type_dropdown);
        Select dropdown = new Select(driver.findElement(By.id(fuel_type_dropdown)));
        dropdown.selectByVisibleText("Petrol");
    }

    public static void year_select_dropdown() {
        common.waitForElementToBeClickable("id", reg_year_dropdown);
        Select dropdown = new Select(driver.findElement(By.id(reg_year_dropdown)));
        dropdown.selectByVisibleText("2018/68");
    }

    public static void colour_select_dropdown() {
        common.waitForElementToBeClickable("id", colour_dropdown);
        Select dropdown = new Select(driver.findElement(By.id(colour_dropdown)));
        dropdown.selectByVisibleText("Black");
    }

    public static void derivative_select_dropdown() {
        common.waitForElementToBeClickable("id", derivative_dropdown);
        Select dropdown = new Select(driver.findElement(By.id(derivative_dropdown)));
        dropdown.selectByVisibleText("HATCHBACK 1.5 TSI EVO SE [Nav] 5dr DSG (2017 to 2018)");
    }
}