package pageObjeckts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class Header {
    private WebDriver driver;
    public Header (WebDriver driver){
        this.driver = driver;
    }

    private By logotypeInHeader = By.xpath(".//div/a");
    private By constructorButton = By.xpath(".//header/nav[1]/ul/li[1]/a[@class='AppHeader_header__link__3D_hX']");
    private By headerSection = By.className("AppHeader_header__X9aJA");
    private By personalCabinetButton = By.xpath(".//nav/a[@class = 'AppHeader_header__link__3D_hX']");

    @Step("Нажимаем на кнопку Личный кабинет")
    public void pressPersonalCabinetButton() {
        driver.findElement(personalCabinetButton).click();
    }
    @Step("Нажимаем на логотип в хедере")
    public void pressOnLogotype(){
        driver.findElement(logotypeInHeader).click();
    }

    @Step("Нажимаем на логотип в хедере")
    public void pressOnConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    @Step("Проверяем видимость хедера")
    public void headerSectionIsVisible() {
        new WebDriverWait(driver, 7).until(
        ExpectedConditions.presenceOfElementLocated(headerSection));
        assertTrue(driver.findElement(headerSection).isDisplayed());
    }
}
