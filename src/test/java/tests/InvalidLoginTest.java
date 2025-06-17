package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import propertyUtility.PropertyUtility;

public class InvalidLoginTest extends BaseTest {

    @Test

    public void loginTest() {

        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();

        LoginPage login = new LoginPage(driver);
        login.isPageLoaded();
        propertyUtility = new PropertyUtility("InvalidConfigData");
        login.login(propertyUtility.getDataValue("username"), propertyUtility.getDataValue("password"));
        login.isPageLoaded();
        login.errorMessage();
    }
}
