package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static constants.Constants.NO_NOTIFICATION;
import static extentUtility.ExtentHelper.logInfo;
import static extentUtility.ReportEventType.INFO_STEP;

public class EditAccountPage extends BasePage {

    private By editTabButton = By.xpath("//a[text()='Editați']");
    private By uploadFileElement = By.id("edit-picture-upload");
    private By romanianLanguage = By.id("edit-language-ro");
    private By englishLanguage = By.id("edit-language-en");
    private By notificationList = By.id("edit-comment-notify");

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override

    public void isPageLoaded() {
    }

    public void goToEditTab(){
        logInfo(INFO_STEP, "User clicks the Edit Account button");
        elementMethods.clickElement(editTabButton);
    }

    public void editAccount(Map<String, Object> editValue){
        uploadImage((String) editValue.get("pictureFile"));
        chooseLanguage((String) editValue.get("language"));
        chooseNotifications(NO_NOTIFICATION);
    }

    public void uploadImage(String pictureFileValue) {
        logInfo(INFO_STEP,"Scroll down");
        elementMethods.scrollPageDown("400");
        logInfo(INFO_STEP,"User uploaded the following picture: " + pictureFileValue);
        elementMethods.uploadDocument(uploadFileElement, pictureFileValue);
    }

    public void chooseLanguage(String language){
        logInfo(INFO_STEP,"Scroll down");
        elementMethods.scrollPageDown("400");
        logInfo(INFO_STEP,"User selects language: " + language);
        List<WebElement> languageList = List.of(driver.findElement(romanianLanguage),
                driver.findElement(englishLanguage));
        elementMethods.chooseElementFromListByText(languageList, language);
    }

    public void chooseNotifications(String notificationValue){
        logInfo(INFO_STEP,"Scroll down");
        elementMethods.scrollPageDown("300");
        logInfo(INFO_STEP,"User chooses notifications value: " + notificationValue);
        elementMethods.chooseElementFromListByText(notificationList, notificationValue);
    }
}
