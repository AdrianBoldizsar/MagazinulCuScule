package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentHelper.logInfo;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class LoginPage extends BasePage{

    private By loginLink = By.xpath("//span[text()='Cont utilizator']");
    private By emailInput = By.id("edit-name");
    private By passwordInput = By.id("edit-pass");
    private By loginButton = By.id("edit-submit");
    private By logOutButton = By.xpath("//span[text()='Ieşire']");
    private By accountButton = By.xpath("//h3[text()='Puncte']");
    private By errorMessage = By.xpath("//h2[text()='Mesaj de eroare']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override

    public void isPageLoaded() {}

    public void login(String email, String password) {
        logInfo(INFO_STEP,"User clicks Login button");
        elementMethods.clickElement(loginLink);
        logInfo(PASS_STEP,"Validate that LoginPage is loaded properly");
        Assert.assertEquals(elementMethods.getTextFromElement(loginLink), "Cont utilizator",
                "Page is not loaded properly");
        logInfo(INFO_STEP,"User fills the email field");
        elementMethods.fillElement(emailInput, email);
        logInfo(INFO_STEP,"User fills the password field");
        elementMethods.fillElement(passwordInput, password);
        logInfo(INFO_STEP,"User clicks the Authenticate button");
        elementMethods.clickElement(loginButton);
    }

    public void isUserLoggedIn() {
        logInfo(PASS_STEP,"Validates that the user can login with valid credentials");
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("puncte"));
        // eu vreau sa am si mesaj la assert!!!
//        Assert.assertEquals(elementMethods.getElement(accountButton).getDomAttribute("h3"),
//                "Puncte","Page is not loaded properly");
    }

    public void errorMessage(){
        logInfo(PASS_STEP,"Validates that the user cannot login with invalid credentials");
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("mesaj de eroare"));
        //la fel ca mai sus, mesaj la assert!!!
//        Assert.assertEquals(elementMethods.getElement(errorMessage).getDomAttribute("h2"),"Mesaj de eroare", "Câmpul Nume utilizator sau adresa e-mail este obligatoriu. " +
//                "Câmpul Parola este obligatoriu.");
    }

    public void logout(){
        logInfo(INFO_STEP, "User clicks the Log out button");
        elementMethods.clickElement(logOutButton);
        logInfo(PASS_STEP,"Validates that the user logged out successfully");
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("cont utilizator"));
    }
}
