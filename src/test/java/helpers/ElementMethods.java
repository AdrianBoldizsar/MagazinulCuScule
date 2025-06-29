package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementMethods {
    public WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions action;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    public void clickElement(By locator) {
        waitForElement(locator);
        getElement(locator).click();
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement getElement(By locator) {
        waitForElement(locator);
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void scrollPageDown(String scrollValue) {
        js.executeScript("window.scrollBy(0," + scrollValue + ")");
    }

    public void fillElement(By locator, String textValue) {
        waitForElement(locator);
        getElement(locator).clear();
        getElement(locator).sendKeys(textValue);
    }

    public void chooseElementFromListByText(By locator, String textValue) {
        for (WebElement element : getElements(locator)) {
            if (element.getText().equals(textValue)) {
                element.click();
                break;
            }
        }
    }

    public void chooseElementFromListByText(List<WebElement> elementList, String textValue) {
        for (WebElement element : elementList) {
            if (element.getText().equals(textValue)) {
                element.click();
                break;
            }
        }
    }

    public String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public void uploadDocument(By locator, String pathValue) {
        String pictureFilePaths = "src/test/resources/picture/" + pathValue;
        File file = new File(pictureFilePaths);
        getElement(locator).sendKeys(file.getAbsolutePath());
    }

//    public void clickElement(WebElement element) {
//        waitForElement(element);
//        element.click();
//    }
//
//    public void selectElementByText(By locator, String textValue) {
//        waitForElement(locator);
//        Select selectElement = new Select(driver.findElement(locator));
//        selectElement.selectByVisibleText(textValue);
//    }
//
//    public void fillElement(WebElement element, String textValue) {
//        waitForElement(element);
//        element.clear();
//        element.sendKeys(textValue);
//    }
//
//    public void fillElement(By locator, Keys keyValue) {
//        waitForElement(locator);
//        getElement(locator).sendKeys(keyValue);
//    }
//
//    public void fillElement(WebElement element, Keys keyValue) {
//        waitForElement(element);
//        element.sendKeys(keyValue);
//    }
//
//    public void setWait(Long milliSeconds){
//        try {
//            wait(milliSeconds);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void waitForElement(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
}
