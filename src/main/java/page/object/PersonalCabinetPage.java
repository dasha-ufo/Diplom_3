package page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class PersonalCabinetPage {
    private WebDriver driver;
    public PersonalCabinetPage (WebDriver driver){
        this.driver = driver;
    }
    private By navigationBlock = By.className("Account_nav__Lgali");
    private By profileContentBlock = By.className("Profile_profile__3dzvr");
    private By profileButton = By.xpath(".//li[1][@class='Account_listItem__35dAP']");
    private By historyOfOrdersButton = By.xpath(".//li[2][@class='Account_listItem__35dAP']");
    private By exitButton = By.xpath(".//li[3][@class='Account_listItem__35dAP']/button");


    @Step("Проверяем видимость блока с навигацией профиля")
    public void isNavigationBlockVisible(){
        new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(navigationBlock));
        assertTrue(driver.findElement(navigationBlock).isDisplayed());
    }

    @Step("Проверяем видимость блока с данными профиля")
    public void isContentBlockVisible(){
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(profileContentBlock));
        assertTrue(driver.findElement(profileContentBlock).isDisplayed());
     }
    @Step("Дождаться пока загрузится страница профиля")
    public void isPersonalAccountPageVisible(){
        isNavigationBlockVisible();
        isContentBlockVisible();
    }
    @Step("Нажимаем на кнопку выход")
    public void pressExitButton(){
        driver.findElement(exitButton).click();
    }

}

