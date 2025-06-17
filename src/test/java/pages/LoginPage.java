package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{

    private By loginLink = By.xpath("//span[text()='Cont utilizator']");
    private By emailInput = By.id("edit-name");
    private By passwordInput = By.id("edit-pass");
    private By loginButton = By.id("edit-submit");
    private By accountButton = By.xpath("//h3[text()='Puncte']");
    private By errorMessage = By.xpath("//h2[text()='Mesaj de eroare']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Override

    public void isPageLoaded() {
    }

    public void login(String email, String password) {
        elementMethods.clickElement(loginLink);
        elementMethods.fillElement(emailInput, email);
        elementMethods.fillElement(passwordInput, password);
        elementMethods.clickElement(loginButton);
    }

    public void isUserLoggedIn() {
        Assert.assertEquals(elementMethods.getElement(accountButton).getDomAttribute("h3"),
                "Puncte","Page is not loaded properly");
    }

    public void errorMessage(){
        Assert.assertEquals(elementMethods.getElement(errorMessage).getDomAttribute("h2"),"Mesaj de eroare", "Câmpul Nume utilizator sau adresa e-mail este obligatoriu." +
                "Câmpul Parola este obligatoriu.");

    }
}
