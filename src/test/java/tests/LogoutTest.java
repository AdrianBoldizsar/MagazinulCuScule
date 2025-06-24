package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import propertyUtility.PropertyUtility;

public class LogoutTest extends BaseTest {

    @Test

    public void logoutTest() {
        LoginPage logout = new LoginPage(driver);
        propertyUtility = new PropertyUtility("ConfigData");
        logout.login(propertyUtility.getDataValue("username"), propertyUtility.getDataValue("password"));
        logout.logout();
    }
}
