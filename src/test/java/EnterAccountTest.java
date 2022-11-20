import PageObject.ForgotPasswordPage;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class EnterAccountTest {
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
    @DisplayName("Тест входа по кнопке Войти в аккаунт на главной странице")
    public void EnterAccountMainPageTest() {
        mainPage.clickEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("burgerlover@email.ru", "password");
        mainPage.checkMakeUpBurgerIsVisible();
    }

    @Test
    @DisplayName("Тест входа по кнопке Личный кабинет")
    public void EnterPersonalAccountTest() {
        mainPage.clickPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("burgerlover@email.ru", "password");
        mainPage.checkMakeUpBurgerIsVisible();
    }

    @Test
    @DisplayName("Тест входа по кнопке в форме регистрации")
    public void EnterRegistrationFormTest() {
        mainPage.clickPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickEnterButton();
        loginPage.login("burgerlover@email.ru", "password");
        mainPage.checkMakeUpBurgerIsVisible();
    }

    @Test
    @DisplayName("Тест входа по кнопке в форме восстановления пароля")
    public void EnterRestorePasswordFormTest() {
        mainPage.clickPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRestorePasswordButton();
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.clickEnterButton();
        loginPage.login("burgerlover@email.ru", "password");
        mainPage.checkMakeUpBurgerIsVisible();
    }
}
