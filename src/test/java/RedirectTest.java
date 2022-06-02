import Models.User;
import PageObjects.*;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RedirectTest {

    private HomePage homePage;
    private RegisterPage registerPage;
    private UserProfilePage userProfilePage;

    @Before
    public void setup(){
        Configuration.startMaximized = true;
        homePage = new HomePage();
        registerPage = new RegisterPage();
        User user = User.getRandom();
        RegisterPage objRegisterPage = open(registerPage.REGISTER_URL, RegisterPage.class);
        LoginPage objLoginPage = page(LoginPage.class);
        objRegisterPage.setName();
        objRegisterPage.setEmail();
        objRegisterPage.setValidPassword();
        objRegisterPage.signUpButtonClick();
        sleep(1000);
        objLoginPage.setEmail();
        objLoginPage.setValidPassword();
        objLoginPage.signInButtonClick();
        sleep(1000);
    }

    @After
    public void teardown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Check redirect to User Profile")
    public void redirectToUserProfile(){
        HomePage objHomePage = open(homePage.BASE_URL, HomePage.class);
        UserProfilePage objUserProfilePage = page(UserProfilePage.class);
        objHomePage.userProfileButtonClick();
        objUserProfilePage.logOutButton.shouldBe(visible);
    }

    @Test
    @DisplayName("Check redirect to Constructor page from User Profile by clicking 'Конструктор' button")
    public void redirectToConstructorPageWithConstructorButton(){
        userProfilePage = new UserProfilePage();
        UserProfilePage objUserProfilePage = page(UserProfilePage.class);
        HomePage objHomePage = page(HomePage.class);
        objHomePage.userProfileButtonClick();
        objUserProfilePage.constructorButtonClick();
        objHomePage.placeOrderButton.shouldBe(visible);
    }

    @Test
    @DisplayName("Check redirect to Constructor page from User Profile by clicking logo")
    public void redirectToConstructorPageWithLogo(){
        userProfilePage = new UserProfilePage();
        UserProfilePage objUserProfilePage = page(UserProfilePage.class);
        HomePage objHomePage = page(HomePage.class);
        objHomePage.userProfileButtonClick();
        objUserProfilePage.logoStellarBurgersClick();
        objHomePage.placeOrderButton.shouldBe(visible);
    }
}