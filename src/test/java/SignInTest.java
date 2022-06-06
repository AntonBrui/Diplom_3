import Models.User;
import PageObjects.ForgotPasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SignInTest {

    private HomePage homePage;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setup(){
        Configuration.startMaximized = true;
        homePage = new HomePage();
        registerPage = new RegisterPage();
        forgotPasswordPage = new ForgotPasswordPage();
        User.getRandom();
        RegisterPage objRegisterPage = open(registerPage.getREGISTER_URL(), RegisterPage.class);
        objRegisterPage.setName();
        objRegisterPage.setEmail();
        objRegisterPage.setValidPassword();
        objRegisterPage.signUpButtonClick();
    }

    @After
    public void teardown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("SignIn by clicking 'Войти в аккаунт' button on Home page")
    public void signInWithSignInButtonOnHomePage(){
        HomePage objHomePage = open(homePage.getBASE_URL(), HomePage.class);
        LoginPage objLoginPage = page(LoginPage.class);
        objHomePage.signInButtonClick();
        objLoginPage.setEmail();
        objLoginPage.setValidPassword();
        objLoginPage.signInButtonClick();
        objHomePage.placeOrderButton.shouldBe(visible);
    }

    @Test
    @DisplayName("SignIn by clicking 'Личный кабинет' button on Home page")
    public void signInWithUserProfileButtonOnHomePage(){
        HomePage objHomePage = open(homePage.getBASE_URL(), HomePage.class);
        LoginPage objLoginPage = page(LoginPage.class);
        objHomePage.userProfileButtonClick();
        objLoginPage.setEmail();
        objLoginPage.setValidPassword();
        objLoginPage.signInButtonClick();
        sleep(2000);
        objHomePage.placeOrderButton.shouldBe(visible);
    }

    @Test
    @DisplayName("SignIn by register page")
    public void signInWithRegisterForm(){
        RegisterPage objRegisterPage = open(registerPage.getREGISTER_URL(), RegisterPage.class);
        HomePage objHomePage = page(HomePage.class);
        LoginPage objLoginPage = page(LoginPage.class);
        objRegisterPage.signInButtonClick();
        objLoginPage.setEmail();
        objLoginPage.setValidPassword();
        objLoginPage.signInButtonClick();
        objHomePage.placeOrderButton.shouldBe(visible);
    }

    @Test
    @DisplayName("SignIn by forgot password page")
    public void signInWithForgotPasswordForm(){
        ForgotPasswordPage objForgotPasswordPage = open(forgotPasswordPage.FORGOT_PASSWORD_URL, ForgotPasswordPage.class);
        HomePage objHomePage = page(HomePage.class);
        LoginPage objLoginPage = page(LoginPage.class);
        objForgotPasswordPage.signInButtonClick();
        objLoginPage.setEmail();
        objLoginPage.setValidPassword();
        objLoginPage.signInButtonClick();
        objHomePage.placeOrderButton.shouldBe(visible);
    }
}
