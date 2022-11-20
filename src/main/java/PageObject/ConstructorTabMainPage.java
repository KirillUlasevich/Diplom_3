package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Objects;

public class ConstructorTabMainPage {


    // кнопка вкладки Соусы
    @FindBy(how = How.XPATH, using = "//span[@class='text text_type_main-default'][text()='Соусы']")
    private SelenideElement sauceTab;

    // кнопка вкладки Начинки
    @FindBy(how = How.XPATH, using = "//span[@class='text text_type_main-default'][text()='Начинки']")
    private SelenideElement toppingsTab;

    // кнопка вкладки Начинки
    @FindBy(how = How.XPATH, using = "//span[@class='text text_type_main-default'][text()='Булки']")
    private SelenideElement bunsTab;


    @Step("клик по вкладке Соусы")
    public void clickSauceTab(){
        sauceTab.click();
    }
    @Step("клик по вкладке Начинки")
    public void clickToppingsTab(){
        toppingsTab.click();
    }
    @Step("клик по вкладке Булки")
    public void clickBunsTab(){
        bunsTab.click();
    }

    @Step("проверка что вкладка Соусы активна")
    public void checkSouseTabActive(){
        Objects.requireNonNull(sauceTab.getAttribute("class")).contains("tab_tab__1SPyG tab_tab_type_current__2BEPc");
    }
    @Step("проверка что вкладка Начинки активна")
    public void checkToppingsTabActive(){
        Objects.requireNonNull(toppingsTab.getAttribute("class")).contains("tab_tab__1SPyG tab_tab_type_current__2BEPc");
    }
    @Step("проверка что вкладка Булки активна")
    public void checkBunsTabActive() {
        Objects.requireNonNull(bunsTab.getAttribute("class")).contains("tab_tab__1SPyG tab_tab_type_current__2BEPc");
    }

}
