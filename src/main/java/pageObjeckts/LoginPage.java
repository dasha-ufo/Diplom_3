package pageObjeckts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginPage {


    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private By enterButton = By.cssSelector(".button_button__33qZ0");
    private By registrationButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and (contains(text(),'Зарегистрироваться'))]");
    private By remindPasswordButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and (contains(text(),'Восстановить пароль'))]");

    private By enterSection = By.className("Auth_login__3hAey");

    private By emilField = By.xpath(".//fieldset[1]/div/div/input[@class='text input__textfield text_type_main-default']");

    private By passwordField = By.xpath(".//fieldset[2]/div/div/input[@class='text input__textfield text_type_main-default']");



    @Step("Переходим на страницу логина")
    public void goToLoginPage(){
        driver.get("https://stellarburgers.nomoreparties.site/login");
    }
    @Step("Нажимаем кнопку Зарегистрироваться")
    public void pressRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    @Step("Нажимаем кнопку восстановить пароль на странице логина")
    public void pressRemindPasswordButton() {
        driver.findElement(remindPasswordButton).click();
    }
    @Step("Проверяем видимость полей для входа на странице логина")
    public void enterSectionIsVisible() {
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOf(driver.findElement(enterSection))
            );}


    @Step("Заполняем поле email")
    public void fillEmail(String email) {
            driver.findElement(emilField).sendKeys(email);
    }

    @Step("Заполняем поле password")
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажимаем на кнопку Войти")
    public void pressEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Переходим в раздел /login, авторизуемся и нажимаем войти")
    public void fullLogin(String email, String password) {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        new WebDriverWait(driver, 7).until(
                ExpectedConditions.visibilityOf(driver.findElement(enterSection))
        );
        driver.findElement(emilField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(enterButton).click();
    }
}

