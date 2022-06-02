import PageObjects.HomePage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorRedirectTest {

    private HomePage homePage;

    @Before
    public void setup(){
        Configuration.startMaximized = true;
        homePage = new HomePage();
    }

    @After
    public void teardown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Redirect to the sauces section")
    public void redirectToFillingsSection(){
        HomePage objHomePage = open(homePage.BASE_URL, HomePage.class);
        objHomePage.fillingsTabButtonClick();
        objHomePage.fillingsTabButton.shouldHave(cssValue("color", "rgba(255, 255, 255, 1)"));
    }

    @Test
    @DisplayName("Redirect to the sauces section")
    public void redirectToSoucesSection(){
        HomePage objHomePage = open(homePage.BASE_URL, HomePage.class);
        objHomePage.saucesTabButtonClick();
        objHomePage.saucesTabButton.shouldHave(cssValue("color", "rgba(255, 255, 255, 1)"));
    }

    @Test
    @DisplayName("Redirect to the sauces section")
    public void redirectToRollsSection(){
        HomePage objHomePage = open(homePage.BASE_URL, HomePage.class);
        objHomePage.saucesTabButtonClick();
        objHomePage.rollsTabButtonClick();
        objHomePage.rollsTabButton.shouldHave(cssValue("color", "rgba(255, 255, 255, 1)"));
    }
}