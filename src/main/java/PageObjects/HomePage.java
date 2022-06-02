package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    public final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    //Кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//a/p[text()='Личный Кабинет']")
    public SelenideElement userProfileButton;

    //Кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    public SelenideElement signInButton;

    //Кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement placeOrderButton;

    //Кнопка раздела "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    public SelenideElement rollsTabButton;

    //Кнопка раздела "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    public SelenideElement saucesTabButton;

    //Кнопка раздела "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    public SelenideElement fillingsTabButton;

    //Заголовок раздела "Булки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    public SelenideElement rollsTitle;

    //Заголовок раздела "Соусы"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    public SelenideElement saucesTitle;

    //Заголовок раздела "Начинки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    public SelenideElement fillingsTitle;


    public void signInButtonClick() {signInButton.click();}

    public void userProfileButtonClick() {userProfileButton.click();}

    public void rollsTabButtonClick() {rollsTabButton.click();}

    public void saucesTabButtonClick() {saucesTabButton.click();}

    public void fillingsTabButtonClick() {fillingsTabButton.click();}





}
