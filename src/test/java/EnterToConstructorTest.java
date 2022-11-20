import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.AccountPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class EnterToConstructorTest {
    MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = open(Config.URL, MainPage.class);
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест перехода по клику на кнопку Конструктор")
    public void EnterConstructor() {
        mainPage.clickEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("email@email.ru", "password");
        mainPage.clickPersonalAccount();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickConstructorButton();
        mainPage.checkMakeUpBurgerIsVisible();
    }

    @Test
    @DisplayName("Тест перехода по клику на логотип")
    public void EnterStellarBurgersLogo() {
        mainPage.clickEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("email@email.ru", "password");
        mainPage.clickPersonalAccount();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickStellarBurgersLogo();
        mainPage.checkMakeUpBurgerIsVisible();
    }

}
