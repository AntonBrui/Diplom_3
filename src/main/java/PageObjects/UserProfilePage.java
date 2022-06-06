package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserProfilePage {

    public final String USER_PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //Кнопка "Выйти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    public SelenideElement logOutButton;

    //Кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//a/p[text()='Конструктор']")
    public SelenideElement constructorButton;

    //Лого "Stellar Burgers"
    @FindBy(how = How.XPATH, using = "//html/body/div/div/header/nav/div/a")
    public SelenideElement logoStellarBurgers;

    public void logOutButtonClick() {logOutButton.click();}

    public void constructorButtonClick() {constructorButton.click();}

    public void logoStellarBurgersClick() {logoStellarBurgers.click();}
}
