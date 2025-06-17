package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import propertyUtility.PropertyUtility;

public class LoginTest extends BaseTest {

    @Test

    public void loginTest() {

        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();

        LoginPage login = new LoginPage(driver);
        login.isPageLoaded();
        propertyUtility = new PropertyUtility("ConfigData");
        login.login(propertyUtility.getDataValue("username"), propertyUtility.getDataValue("password"));
        By myAccount = By.id("page-title");
        login.elementMethods.waitForElement(myAccount);
        login.isPageLoaded();
        login.isUserLoggedIn();
    }
}
