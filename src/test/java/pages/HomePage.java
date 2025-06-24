package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentHelper.logInfo;
import static extentUtility.ReportEventType.PASS_STEP;

public class HomePage extends BasePage{

    private By goToHomePageButton = By.xpath("//img[@alt='Acasă']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override

    public void isPageLoaded() {
        logInfo(PASS_STEP,"Validate that HomePage is loaded properly");
        Assert.assertEquals(elementMethods.getElement(goToHomePageButton).getDomAttribute("alt"),
                "Acasă","Page is not loaded properly");
    }
}
