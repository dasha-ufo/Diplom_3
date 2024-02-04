package pageObjeckts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ConstructorMainPage {
        private WebDriver driver;
        public ConstructorMainPage(WebDriver driver){
            this.driver = driver;
        }

    private By enterToAccountButton = By.cssSelector(".button_button__33qZ0");
    private By mainPageScreen = By.className("App_componentContainer__2JC2W");
    private By bulkiTab = By.xpath(".//div[@style='display: flex;']/div[1]");
    private By sousesTab = By.xpath(".//div[@style='display: flex;']/div[2]");
    private By nachinkiTab = By.xpath(".//div[@style='display: flex;']/div[3]");
    private By bulkiSection = By.xpath(".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/ul[1]");
    private By sousesSection = By.xpath(".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/ul[2]");
    private By nachinkiSection = By.xpath(".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/ul[3]");
    private By blockTab = By.cssSelector("[style='display: flex;']");
    private By bulkiTabActive = By.xpath(".//div/div[1][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    private By sousesTabActive = By.xpath(".//div/div[2][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    private By nachinkiTabActive = By.xpath(".//div/div[3][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");



    @Step("Переходим на главную страницу Stellar Burgers")
    public void goToMainPage(){
        driver.get("https://stellarburgers.nomoreparties.site/");
    }


    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void pressEnterToAccountButton() {
        driver.findElement(enterToAccountButton).click();
    }

    @Step("Проверяем видимость главной страницы")
    public void mainPageIsVisible() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOf(driver.findElement(mainPageScreen))
        );}

    @Step("Проверяем видимость блока с табами")
    public void blockTabIsVisible() {
        new WebDriverWait(driver, 6).until(
                ExpectedConditions.visibilityOf(driver.findElement(blockTab))
        );}

    @Step("Нажимаем на таб Булки")
    public void clickBulkiTab() {
    driver.findElement(bulkiTab).click();
    }

    @Step("Проверяем, что секция с булками видна")
    public void bulkiSectionIsVisible() {
        new WebDriverWait(driver, 6).until(
            ExpectedConditions.visibilityOf(driver.findElement(bulkiSection))
            );
        assertTrue(driver.findElement(bulkiSection).isDisplayed());
    }

    @Step("Проверяем, что таб булки стал активным")
    public void bulkiTabActiveCheck() {
        new WebDriverWait(driver, 6).until(
                ExpectedConditions.visibilityOf(driver.findElement(bulkiTabActive))
        );
        assertTrue(driver.findElement(bulkiTabActive).isDisplayed());
    }

    @Step("Нажимаем на таб Соусы")
    public void clickSousesTab() {
        driver.findElement(sousesTab).click();
    }

    @Step("Проверяем, что секция с соусами видна")
    public void sousesSectionIsVisible() {
        new WebDriverWait(driver, 6).until(
                ExpectedConditions.visibilityOf(driver.findElement(sousesSection))
        );
        assertTrue(driver.findElement(sousesSection).isDisplayed());
    }
    @Step("Проверяем, что таб соусы стал активным")
    public void sousesTabActiveCheck() {
        driver.findElement(sousesTabActive).isDisplayed();
    }

    @Step("Нажимаем на таб начинки")
    public void clickNachinkiTab() {
        driver.findElement(nachinkiTab).click();
    }

    @Step("Проверяем, что секция с начинками видна")
    public void nachinkiSectionIsVisible() {
        new WebDriverWait(driver, 6).until(
                ExpectedConditions.visibilityOf(driver.findElement(sousesSection))
        );
        assertTrue(driver.findElement(nachinkiSection).isDisplayed());
    }
    @Step("Проверяем, что таб начинки стал активным")
    public void nachinkiTabActiveCheck() {
        driver.findElement(nachinkiTabActive).isDisplayed();
    }


}

