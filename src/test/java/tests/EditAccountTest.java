package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.EditAccountPage;
import pages.HomePage;
import pages.LoginPage;
import propertyUtility.PropertyUtility;

import java.util.Map;

public class EditAccountTest extends BaseTest{

    @Test

    public void accountTest(){
        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();

        LoginPage login = new LoginPage(driver);
        propertyUtility = new PropertyUtility("ConfigData");
        login.login(propertyUtility.getDataValue("username"), propertyUtility.getDataValue("password"));
        login.isPageLoaded();

        By myAccount = By.id("page-title");
        login.elementMethods.waitForElement(myAccount);
        login.isPageLoaded();

        EditAccountPage edit = new EditAccountPage(driver);
        edit.goToEditTab();
        propertyUtility=new PropertyUtility("Files");
        Map<String,Object> accountData=propertyUtility.getAllProperties();
        edit.editAccount(accountData);
    }
}
