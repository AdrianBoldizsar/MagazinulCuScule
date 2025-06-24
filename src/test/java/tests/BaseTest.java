package tests;

import extentUtility.ExtentHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import propertyUtility.PropertyUtility;

import java.time.Duration;

import static extentUtility.ExtentHelper.*;
import static extentUtility.ExtentHelper.finishTest;

public class BaseTest {

    WebDriver driver;
    public PropertyUtility propertyUtility;
    public String testName;

    @BeforeSuite

    public void initializeReport(){
        initiateReport();
    }

    @BeforeMethod

    public void openBrowser() {
        driver = new ChromeDriver();
        propertyUtility=new PropertyUtility("ConfigData");
        driver.get(propertyUtility.getDataValue("homepage"));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Da, de acord']")));
        acceptButton.click();

        testName=this.getClass().getSimpleName();
        createTest(testName);
    }

    @AfterMethod

    public void closeBrowser(ITestResult results) {
        if (results.getStatus()== ITestResult.FAILURE){
            String errorMessage=results.getThrowable().getMessage();
            logFailScreenshot(driver, errorMessage);
        }
        if (driver!=null){
            driver.quit();
        }
        finishTest(testName);
    }

    @AfterSuite

    public void finalizeReport(){
        ExtentHelper.generateReport();
    }
}
