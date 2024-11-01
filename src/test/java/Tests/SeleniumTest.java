package Tests;

import Pages.DetailsPage;
import Pages.HomePage;
import Pages.ManualLookUpPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static Pages.CheckRegistrationPage.click_enter_manually;
import static Pages.ValuationPage.validate_amount_range;

public class SeleniumTest {
    static ExtentReports report;
    static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    public static WebDriver driver;

    @BeforeSuite
    public void reportSetup(){
        ExtentSparkReporter spark = new ExtentSparkReporter("src/test/Report/report.html");
        extent.attachReporter(spark);
    }

    @BeforeMethod
    void Setup(){
        driver = new ChromeDriver();
        driver.get("https://www.webuyanycar.com/");
    }

    public void searchForCar(String registration, String mileage){
        HomePage.consent_banner_close();
        HomePage.input_vehicle_reg(registration);
        HomePage.input_mileage(mileage);
        HomePage.click_valuation();
    }

    public void getCarValuation(){
        DetailsPage.input_email();
        DetailsPage.input_postcode();
        DetailsPage.input_telephone();
        DetailsPage.click_valuation();
    }

    public void enterCarManuallyValuation() throws InterruptedException {
        searchForCar("SG18HTN","32000");
        click_enter_manually();
        ManualLookUpPage.click_car_btn();
        ManualLookUpPage.manufacturer_select_dropdown();
        ManualLookUpPage.model_select_dropdown();
        ManualLookUpPage.fuel_type_select_dropdown();
        ManualLookUpPage.year_select_dropdown();
        ManualLookUpPage.colour_select_dropdown();
        ManualLookUpPage.click_paint_btn();
        ManualLookUpPage.derivative_select_dropdown();
        ManualLookUpPage.click_this_is_my_car_btn();
    }

    @Test
    void homePageValidation(){
        test = extent.createTest(
                "Validates that the Home page displays all required fields",
                "It validate if all the fields are present on the page"
        );
        HomePage.consent_banner_close();
        HomePage.validate_vehicle_reg_textbox();
        HomePage.validate_mileage_textbox();
        HomePage.validate_valuation_btn();
    }

    @Test
    void detailPageValidation(){
        test = extent.createTest(
                "Validates that the Details page displays all required fields.",
                "It validate if all the fields are present on the page"
        );
        searchForCar("AD58VNF","32000");
        DetailsPage.validate_email_textbox();
        DetailsPage.validate_postcode_textbox();
        DetailsPage.validate_telephone_textbox();
        DetailsPage.validate_valuation_btn();
    }

    @Test
    void validateBMVDetailsAreCorrect(){
        test = extent.createTest(
                "Validates that registration AD58VNF displays the correct BMW car details.",
                "Check if registration AD58VNF has the correct value on the details page"
        );
        searchForCar("AD58VNF","32000");
        DetailsPage.validate_manufacturer_data("BMW");
        DetailsPage.validate_registration_data("AD58VNF");
        DetailsPage.validate_model_data("1 SERIES DIESEL COUPE - 120d M Sport 2dr");
        DetailsPage.validate_year_data("2008");
    }

    @Test
    void validateBMVPriceRange(){
        test = extent.createTest(
                "Validates that the BMW price is within the 3,000 range.",
                "Check the car price if its on the correct range"
        );
        searchForCar("AD58VNF","32000");
        getCarValuation();
        validate_amount_range(3000);
    }

    @Test
    void validateToyotaDetailsAreCorrect(){
        test = extent.createTest(
                "Validates that registration BW57BOF displays the correct Toyota car details.",
                "Check if registration BW57BOF has the correct value on the details page"
        );
        searchForCar("BW57BOF","32000");
        DetailsPage.validate_manufacturer_data("TOYOTA");
        DetailsPage.validate_registration_data("BW57BOF");
        DetailsPage.validate_model_data("YARIS HATCHBACK - 1.0 VVT-i T2 3dr");
        DetailsPage.validate_year_data("2008");
    }

    @Test
    void validateToyotaPriceRange(){
        test = extent.createTest(
                "Validates that the Toyota price is within the 1,000 range.",
                "Check the car price if its on the correct range"
        );
        searchForCar("BW57BOF","32000");
        getCarValuation();
        validate_amount_range(1000);
    }

    @Test
    void validateSkodaDetailsAreCorrect(){
        test = extent.createTest(
                "Validates that registration KT17DLX displays the correct Skoda car details.",
                "Check if registration KT17DLX has the correct value on the details page"
        );
        searchForCar("KT17DLX","32000");
        DetailsPage.validate_manufacturer_data("SKODA");
        DetailsPage.validate_registration_data("KT17DLX");
        DetailsPage.validate_model_data("SUPERB DIESEL ESTATE - 2.0 TDI CR 190 Sport Line 5dr DSG");
        DetailsPage.validate_year_data("2017");
    }

    @Test
    void validateSkodaPriceRange(){
        test = extent.createTest(
                "Validates that the Skoda price is within the 10,000 range.",
                "Check the car price if its on the correct range"
        );
        searchForCar("KT17DLX","32000");
        getCarValuation();
        validate_amount_range(10000);
    }

    @Test
    void validateVolkswagenDetailsAreCorrect() throws InterruptedException {
        test = extent.createTest(
                "Validates that manually entered Volkswagen details match expected values.",
                "Check if registration AD58VNF has the correct value on the details page"
        );
        enterCarManuallyValuation();
        DetailsPage.validate_manufacturer_data("VOLKSWAGEN");
        DetailsPage.validate_registration_data("SG18HTN");
        DetailsPage.validate_model_data("GOLF HATCHBACK - 1.5 TSI EVO SE [Nav] 5dr DSG");
        DetailsPage.validate_year_data("2018");
    }

    @Test
    void validateVolkswagenPriceRange() throws InterruptedException {
        test = extent.createTest(
                "Validates that the manually entered Volkswagen price is within the 10,000 range.",
                "Check the car price if its on the correct range"
        );
        enterCarManuallyValuation();
        getCarValuation();
        validate_amount_range(10000);
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @AfterSuite
    public void reportCleanUp(){
        extent.flush();
    }
}
