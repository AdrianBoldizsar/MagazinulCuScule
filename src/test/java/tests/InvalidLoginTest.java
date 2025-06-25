package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import propertyUtility.PropertyUtility;

public class InvalidLoginTest extends BaseTest {

    @Test

    public void invalidLoginTest() {

        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();

        LoginPage login = new LoginPage(driver);
        propertyUtility = new PropertyUtility("InvalidConfigData");
        login.login(propertyUtility.getDataValue("username"), propertyUtility.getDataValue("password"));
        login.errorMessage();

        login.errorMessage();
    }
}
