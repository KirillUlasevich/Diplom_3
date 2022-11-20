import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.AccountPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class EnterPersonalAccountTest {
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
    @DisplayName("Тест перехода в личный кабинет")
    public void EnterPersonalAccount() {
        mainPage.clickEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("email@email.ru", "password");
        mainPage.clickPersonalAccount();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.checkProfileHeaderIsVisible();
    }

}
