package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;
    // поле ввода email
    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private SelenideElement emailField;
    // поле ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement passwordField;
    // кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти')]")
    private SelenideElement enterButton;
    // кнопка Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement restorePasswordButton;

    @Step("авторизация: ввод email, пароля и клик по кнопке Войти")
    public void login(String email, String password){
        emailField.setValue(email);
        passwordField.setValue(password);
        enterButton.click();
    }
    @Step("клик по кнопке Зарегистрироваться")
    public void clickRegisterButton(){
        registerButton.click();
    }
    @Step("клик по кнопке Восстановить пароль")
    public void clickRestorePasswordButton(){
        restorePasswordButton.click();
    }
    @Step("проверка видимости поля ввода для email")
    public void checkEmailFieldIsVisible(){
        emailField.shouldBe(visible, Duration.ofSeconds(10));
    }
    @Step("проверка видимости кнопки Зарегистрироваться")
    public void checkRegisterButtonIsVisible(){
        registerButton.shouldBe(visible, Duration.ofSeconds(10));
    }

}
