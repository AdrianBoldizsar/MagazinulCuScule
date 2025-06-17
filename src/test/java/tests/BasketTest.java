package tests;

import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;

public class BasketTest extends BaseTest {

    @Test

    public void testAddProductToBasket() {

        BasketPage basket = new BasketPage(driver);

        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();

        basket.goToSubMenu();
        basket.isPageLoaded();

        basket.addFirstProductToCart();
        basket.isPageLoaded();

        basket.deleteFromBasket();
        basket.isPageLoaded();
    }
}
