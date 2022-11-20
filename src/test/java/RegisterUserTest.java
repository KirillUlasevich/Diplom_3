import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegisterUserTest {
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
    @DisplayName("Тест регистрации с валидными данными")
    public void SuccessfulRegistrationTest() {
        mainPage.clickPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.successfulRegisterUser();
        loginPage.checkRegisterButtonIsVisible();
    }

    @Test
    @DisplayName("Тест ошибки при регистрации с невалидными данными")
    public void RegistrationPasswordFiveSymbolsTest() {
        mainPage.clickPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.unsuccessfulRegisterUser();
        registerPage.checkWrongPasswordWindowIsVisible();
    }

}
