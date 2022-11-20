import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.AccountPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class LogOutTest {
    MainPage mainPage;

    @Before
    public void setup() {
        mainPage = open(Config.URL, MainPage.class);
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест выхода из личного кабинета")
    public void LogoutTest() {
        mainPage.clickEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("email@email.ru", "password");
        mainPage.clickPersonalAccount();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickLogoutButton();
        loginPage.checkEmailFieldIsVisible();
    }
}
