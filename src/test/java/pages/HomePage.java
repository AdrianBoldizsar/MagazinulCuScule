package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage{

    private By goToHomePageButton = By.xpath("//img[@alt='Acasă']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override

    public void isPageLoaded() {
        Assert.assertEquals(elementMethods.getElement(goToHomePageButton).getDomAttribute("alt"),
                "Acasă","Page is not loaded properly");
    }

    public void goToHomePage(String menuValue) {
        elementMethods.scrollPageDown("400");
        elementMethods.chooseElementFromListByText(goToHomePageButton, menuValue);

    }
}
