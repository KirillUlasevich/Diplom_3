package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class AccountPage {

    // заголовок Профиль
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Профиль')]")
    private SelenideElement profileHeader;
    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;
    // логотип Stellar Burgers
    @FindBy(how = How.XPATH, using = ".//div[@class = \"AppHeader_header__logo__2D0X2\"]/a")
    private SelenideElement stellarBurgersLogo;
    // кнопка Выход
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Выход')]")
    private SelenideElement logoutButton;

    @Step("клик по кнопке Выход")
    public void clickLogoutButton() {
        logoutButton.click();
    }

    @Step("клик по кнопке Конструктор")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    @Step("клик по лого stellar burgers")
    public void clickStellarBurgersLogo() {
        stellarBurgersLogo.click();
    }

    @Step("проверка видимости заголовка Профиль")
    public void checkProfileHeaderIsVisible() {
        profileHeader.shouldBe(visible, Duration.ofSeconds(10));
    }

}
