package tests;

import org.testng.annotations.Test;
import pages.AddToBasketPage;
import pages.HomePage;

public class AddToBasketTest extends BaseTest {

    @Test

    public void testAddProductToBasket() {

        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();

        AddToBasketPage basket = new AddToBasketPage(driver);
        basket.goToSubMenu();
        basket.isPageLoaded();

        basket.addFirstProductToCart();
        basket.isPageLoaded();

        basket.removeFromBasket();
        basket.isPageLoaded();

        basket.closeBasket();
        basket.isPageLoaded();

        basket.seeBasketButton();
        basket.isPageLoaded();

        basket.isBasketEmpty();
        basket.isPageLoaded();

        basket.goToHomepage();
        basket.isPageLoaded();
    }
}
