package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    private By goToHomePageButton = By.xpath("//img[@alt='Acasă']");
    private By subMenuButton = By.xpath("//a[text()='Scule Diverse (19)']");
    private By firstProductButton = By.xpath(
            "/html/body/div[3]/div/div[1]/div[2]/div[5]/div/div/div/div/div/div/div[3]/div[1]/div/div/div[8]/span/a");
    private By addToCartButton = By.id("edit-submit-34808");
    private By seeBasketButton = By.xpath("//span[text()='Coș']");
    private By deleteFromBasketButton = By.id("edit-items-0-remove");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override

    public void isPageLoaded() {}

    public void goToHomepage() {
        elementMethods.clickElement(goToHomePageButton);
    }


    public void goToSubMenu() {
        elementMethods.clickElement(subMenuButton);
    }

    public void addFirstProductToCart() {
        elementMethods.clickElement(firstProductButton);
        elementMethods.clickElement(addToCartButton);
    }

    public void seeBasketButton() {
        elementMethods.clickElement(seeBasketButton);
    }

    public void deleteFromBasket() {
        elementMethods.clickElement(deleteFromBasketButton);
    }

}
