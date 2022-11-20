package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {

    // поле ввода имени
    @FindBy(how = How.XPATH, using = "//label[contains(@class, 'input__placeholder text noselect text_type_main-default') and contains(text(),'Имя')]/parent::div/input")
    private SelenideElement nameField;
    // поле ввода Email
    @FindBy(how = How.XPATH, using = "//label[contains(@class, 'input__placeholder text noselect text_type_main-default') and contains(text(),'Email')]/parent::div/input")
    private SelenideElement emailField;
    // поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordField;
    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;
    // окно подсказки Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Некорректный')]")
    private SelenideElement wrongPasswordWindow;
    // кнопка Войти
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterButton;

    @Step("клик по кнопке Зарегистрироваться")
    public void clickRegisterButton(){
        registerButton.click();
    }
    @Step("клик по кнопке Войти")
    public void clickEnterButton(){
        enterButton.click();
    }
    @Step("регистрация пользователя с невалидными данными")
    public void unsuccessfulRegisterUser() {
        nameField.setValue("BurgerLover");
        emailField.setValue(RandomStringUtils.randomAlphanumeric(4) + "@ya.ru");
        passwordField.setValue(RandomStringUtils.randomAlphanumeric(5));
        clickRegisterButton();
    }
    @Step("регистрация пользователя с валидными данными")
    public void successfulRegisterUser() {
        nameField.setValue("BurgerLover");
        emailField.setValue(RandomStringUtils.randomAlphanumeric(4) + "@ya.ru");
        passwordField.setValue(RandomStringUtils.randomAlphanumeric(7));
        clickRegisterButton();
    }
    @Step("проверяет видимости подсказки Некорректный пароль")
    public void checkWrongPasswordWindowIsVisible(){
        wrongPasswordWindow.shouldBe(visible, Duration.ofSeconds(10));
    }
}
