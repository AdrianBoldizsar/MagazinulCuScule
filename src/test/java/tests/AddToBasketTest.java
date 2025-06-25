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
        basket.removeFromBasket();
        basket.closeBasket();
        basket.seeBasketButton();
        basket.isBasketEmpty();

    }
}
