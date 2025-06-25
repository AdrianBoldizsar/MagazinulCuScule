package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentHelper.logInfo;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class AddToBasketPage extends BasePage {

    private By pageTitle = By.id("page-title");
    private By subMenuButton = By.xpath("//a[text()='Scule Diverse (19)']");
    private By firstProductButton = By.xpath(
            "/html/body/div[3]/div/div[1]/div[2]/div[5]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[8]/span/a");
    private By addToCartButton = By.id("edit-submit-34808");
    private By seeBasketButton = By.xpath("//span[text()='Coș']");
    private By removeFromBasketButton = By.id("edit-items-0-remove");
    private By closeBasketButton = By.id("cboxClose");

    public AddToBasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        logInfo(PASS_STEP,"Validate that product page is loaded properly");
        Assert.assertEquals(elementMethods.getTextFromElement(pageTitle),"Scule Diverse","Page is not loaded properly");
    }

    public void goToSubMenu() {
        logInfo(INFO_STEP,"User clicks on the submenu button");
        elementMethods.clickElement(subMenuButton);
    }

    public void addFirstProductToCart() {
        logInfo(INFO_STEP,"User clicks on the first product");
        elementMethods.clickElement(firstProductButton);
        logInfo(INFO_STEP,"User clicks Add to basket button");
        elementMethods.clickElement(addToCartButton);
        logInfo(PASS_STEP,"Validate that the basket is not empty");
    }

    public void removeFromBasket() {
        logInfo(INFO_STEP,"User clicks the Remove from basket button");
        elementMethods.clickElement(removeFromBasketButton);
    }

    public void closeBasket(){
        logInfo(INFO_STEP,"User clicks the X to close the basket");
        elementMethods.clickElement(closeBasketButton);
    }

    public void seeBasketButton() {
        logInfo(INFO_STEP,"User clicks the Basket button");
        elementMethods.clickElement(seeBasketButton);
    }

    public void isBasketEmpty() {
        logInfo(PASS_STEP,"Validate that the basket is empty");
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("nu sunt produse în coş."));
    }
}
