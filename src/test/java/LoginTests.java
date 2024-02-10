import factory.browsers.ChooseBrowser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.object.*;
import api.data.responses.DeleteAccount;
import api.data.responses.RegisterAccount;
import api.data.pojo.RegistrationBodyForm;

public class LoginTests {
    private WebDriver driver;
    private RegisterAccount registerAccount;
    private RegistrationBodyForm registrationBodyForm;
    private String email;
    private String password;
    private Response responseForDelete;

    @Before
    public void startUp() {
        driver = ChooseBrowser.chooseWebDriver();
        registerAccount = new RegisterAccount();
        registrationBodyForm = RegistrationBodyForm.randomAccount();
        password = registrationBodyForm.getPassword();
        email = registrationBodyForm.getEmail();
        responseForDelete = registerAccount.create(registrationBodyForm);
    }

    @After
    public void cleanUp() {
    DeleteAccount.deleteUserRequestWithToken(responseForDelete);
    driver.quit();
   }

    @Test
    @DisplayName("Вход через кнопку «Войти в аккаунт» на главной")
    @Description("Входим через кнопку «Войти в аккаунт» на главной странице")
    public void loginViaEnterToAccountButton() {
        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.goToMainPage();
        constructorMainPage.pressEnterToAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterSectionIsVisible();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.pressEnterButton();

        constructorMainPage.mainPageIsVisible();
    }


    @Test
    @DisplayName("Вход через кнопку из раздела «Личный кабинет»")
    @Description("Входим через кнопку личного кабинета на главной странице")
    public void loginViaPersonalCabinet() {
        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.goToMainPage();

        Header header = new Header(driver);
        header.pressPersonalCabinetButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterSectionIsVisible();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.pressEnterButton();

        constructorMainPage.mainPageIsVisible();
        header.headerSectionIsVisible();
    }

    @Test
    @DisplayName("Вход через кнопку из раздела регистрации")
    @Description("На странице регистрации нажимаем кнопку войти и логинимся")
    public void loginViaRegistrationPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.pressRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToRegistrationPage();
        registrationPage.pressEnterButton();

        loginPage.enterSectionIsVisible();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.pressEnterButton();

        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.mainPageIsVisible();
    }

    @Test
    @DisplayName("Вход через восстановление пароля")
    @Description("Вход со страницы восстановление пароля")
    public void loginViaRemindPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.pressRemindPasswordButton();

        RemindPasswordPage remindPasswordPage = new RemindPasswordPage(driver);
        remindPasswordPage.pressEnterButton();

        loginPage.enterSectionIsVisible();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.pressEnterButton();

        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.mainPageIsVisible();
    }
}
