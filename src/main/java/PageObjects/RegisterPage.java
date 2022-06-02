package PageObjects;

import Models.User;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    public final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";

    //Поле "Имя"
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    public SelenideElement nameInput;

    //Поле "Email"
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    public SelenideElement emailInput;

    //Поле "Password"
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public SelenideElement passwordInput;

    //Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement signUpButton;

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//p/a[text()='Войти']")
    public SelenideElement signInButton;

    //Сообщение о некорректном пароле
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    public SelenideElement invalidPasswordMessage;


    public void setName() {$(nameInput).sendKeys(User.getName());}

    public void setEmail() {$(emailInput).sendKeys(User.getEmail());}

    public void setValidPassword() {$(passwordInput).sendKeys(User.getPassword());}

    public void setInvalidPassword() {$(passwordInput).sendKeys("123");}

    public void signUpButtonClick() {signUpButton.click();}

    public void signInButtonClick() {signInButton.click();}

}
