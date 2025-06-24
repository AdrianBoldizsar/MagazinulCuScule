package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import propertyUtility.PropertyUtility;

public class ValidLoginTest extends BaseTest {

    @Test

    public void validLoginTest() {

        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();

        LoginPage login = new LoginPage(driver);
        propertyUtility = new PropertyUtility("ConfigData");
        login.login(propertyUtility.getDataValue("username"), propertyUtility.getDataValue("password"));
        login.isPageLoaded();

        By myAccount = By.id("page-title");
        login.elementMethods.waitForElement(myAccount);
        login.isPageLoaded();

        login.isUserLoggedIn();
    }
}
