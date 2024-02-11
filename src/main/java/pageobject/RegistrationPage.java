package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private By nameFieldRegistration = By.xpath("//fieldset[1]/div/div/input");
    private By emailFieldRegistration = By.xpath("//fieldset[2]/div/div/input");
    private By passwordFieldRegistration = By.xpath("//fieldset[3]/div/div/input");
    private By registrationConfirmButton = By.cssSelector(".button_button__33qZ0");
    private By passwordError = By.cssSelector(".input__error");
    private By enterButton = By.className("Auth_link__1fOlj");

    @Step("Переходим на страницу регистрации")
    public void goToRegistrationPage(){
        driver.get(REGISTRATION_PAGE_URL);
    }
    @Step("Заполняем поле имя")
    public void fillNameField(String name) {
        driver.findElement(nameFieldRegistration).sendKeys(name);
    }


    @Step("Заполняем поле email")
    public void fillEmailField (String email) {
        driver.findElement(emailFieldRegistration).sendKeys(email);
    }

    @Step("Заполняем поле пароль")
    public void fillPasswordField (String password) {
        driver.findElement(passwordFieldRegistration).sendKeys(password);
    }


    @Step("Нажимаем кнопку Зарегистрироваться")
    public void pressRegistrationConfirmButton() {
        driver.findElement(registrationConfirmButton).click();
    }

    @Step("Нажимаем кнопку Войти")
    public void pressEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Проверка отображения ошибки о неправильном пароле")
    public void passwordErrorVisible() {
        driver.findElement(passwordError).isDisplayed();
    }
}

