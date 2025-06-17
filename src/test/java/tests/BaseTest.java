package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import propertyUtility.PropertyUtility;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    public PropertyUtility propertyUtility;

    @BeforeMethod

    public void openBrowser() {
        driver = new ChromeDriver();
        propertyUtility=new PropertyUtility("ConfigData");
        driver.get(propertyUtility.getDataValue("homepage"));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Da, de acord']")));
        acceptButton.click();
    }

    @AfterMethod

    public void closeBrowser() {
        driver.quit();

    }
}
