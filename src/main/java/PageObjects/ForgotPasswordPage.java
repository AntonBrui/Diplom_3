package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    public final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//p/a[text()='Войти']")
    public SelenideElement signInButton;

    public void signInButtonClick() {signInButton.click();}
}
