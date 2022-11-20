import PageObject.ConstructorTabMainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorPageTest {
    ConstructorTabMainPage constructorTabMainPage;

    @Before
    public void setUp() {
        constructorTabMainPage = open(Config.URL, ConstructorTabMainPage.class);

    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест переключения на вкладку Булки")
    public void checkSwitchBunsTabs() {
        constructorTabMainPage.clickToppingsTab();
        constructorTabMainPage.clickBunsTab();
        constructorTabMainPage.checkBunsTabActive();
    }
    @Test
    @DisplayName("Тест переключения на вкладку Соусы")
    public void checkSwitchSauceTabs() {
        constructorTabMainPage.clickSauceTab();
        constructorTabMainPage.checkSouseTabActive();
    }

    @Test
    @DisplayName("Тест переключения на вкладку Начинки")
    public void checkSwitchToppingsTabs() {
        constructorTabMainPage.clickToppingsTab();
        constructorTabMainPage.checkToppingsTabActive();
    }

}