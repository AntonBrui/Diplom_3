package PageObjects;

import Models.User;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    //Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div/p[1]/a")
    public SelenideElement signUpButton;

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    public SelenideElement signInButton;

    //Поле "Email"
    @FindBy(how = How.XPATH, using = "//*[@class='text input__textfield text_type_main-default']")
    public SelenideElement emailInput;

    //Поле "Password"
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public SelenideElement passwordInput;

    public void signUpButtonClick() {signUpButton.click();}

    public void setEmail() {$(emailInput).sendKeys(User.getEmail());}

    public void setValidPassword() {$(passwordInput).sendKeys(User.getPassword());}

    public void signInButtonClick() {
        signInButton.click();
    }


}
