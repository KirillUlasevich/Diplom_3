package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    // кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement personalAccountButton;
    // кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти в аккаунт')]")
    private SelenideElement enterAccountButton;
    // заголовок Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[contains(text(),'Соберите бургер')]")
    private SelenideElement makeBurgerHeader;

    @Step("клик по кнопке Личный кабинет")
    public void clickPersonalAccount() {
        personalAccountButton.click();
    }

    @Step("клик по кнопке Войти в аккаунт")
    public void clickEnterAccount() {
        enterAccountButton.click();
    }

    @Step("проверка видимости заголовка Соберите бургер")
    public void checkMakeUpBurgerIsVisible() {
        makeBurgerHeader.shouldBe(visible, Duration.ofSeconds(10));
    }


}
