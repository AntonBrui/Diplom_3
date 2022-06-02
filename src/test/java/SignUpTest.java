import Models.User;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class SignUpTest {

    private HomePage homePage;

    @Before
    public void setup(){
        Configuration.startMaximized = true;
        homePage = new HomePage();
        User user = User.getRandom();
        }

    @After
    public void teardown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Register user with valid data")
    public void signUpUserWithValidData(){
        HomePage objHomePage = open(homePage.BASE_URL, HomePage.class);
        LoginPage objLoginPage = page(LoginPage.class);
        RegisterPage objRegisterPage = page(RegisterPage.class);
        objHomePage.signInButtonClick();
        objLoginPage.signUpButtonClick();
        objRegisterPage.setName();
        objRegisterPage.setEmail();
        objRegisterPage.setValidPassword();
        objRegisterPage.signUpButtonClick();
        sleep(2000);
        objLoginPage.signInButton.shouldBe(visible);
    }

    @Test
    @DisplayName("Register user with invalid password")
    public void signUpUserWithInvalidPassword(){
        HomePage objHomePage = open(homePage.BASE_URL, HomePage.class);
        LoginPage objLoginPage = page(LoginPage.class);
        RegisterPage objRegisterPage = page(RegisterPage.class);
        objHomePage.signInButtonClick();
        objLoginPage.signUpButtonClick();
        objRegisterPage.setName();
        objRegisterPage.setEmail();
        objRegisterPage.setInvalidPassword();
        objRegisterPage.signUpButtonClick();
        objRegisterPage.invalidPasswordMessage.shouldBe(visible);
        objRegisterPage.invalidPasswordMessage.shouldHave(text("Некорректный пароль"));
    }
}