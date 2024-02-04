import factoryBrowsers.WebDriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjeckts.ConstructorMainPage;
import pageObjeckts.Header;
import pageObjeckts.LoginPage;
import pageObjeckts.RegistrationPage;
import testDataCreateApi.apiResponses.DeleteAccount;
import testDataCreateApi.apiResponses.LoginAccount;
import testDataCreateApi.pojo.RegistrationBodyForm;

public class RegistrationTest {

    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проходим успешный сценарий регистрации и оказываемся на странице залогина")
    public void checkSuccessRegistration() throws InterruptedException {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(6) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(6);

        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.goToMainPage();

        Header header = new Header(driver);
        header.pressPersonalCabinetButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.pressRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToRegistrationPage();
        registrationPage.fillNameField(name);
        registrationPage.fillEmailField(email);
        registrationPage.fillPasswordField(password);
        registrationPage.pressRegistrationConfirmButton();

        Thread.sleep(10000);
        loginPage.enterSectionIsVisible();

        RegistrationBodyForm registrationBodyForm = new RegistrationBodyForm(email, password);
        LoginAccount loginAccount = new LoginAccount();
        Response userForDelete = loginAccount.loginRequest(registrationBodyForm);
        DeleteAccount.deleteUserRequestWithToken(userForDelete);
    }

    @Test
    @DisplayName("Ошибка при регистрации с паролем менее 6 символов")
    @Description("При регистрации вводим пароль 5 символов и проверяем отображение ошибки")
    public void wrongPasswordRegistratoin() {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(6) + "@yandex.ru";
        String passwordFiveSigns = RandomStringUtils.randomAlphabetic(5);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToRegistrationPage();
        registrationPage.fillNameField(name);
        registrationPage.fillEmailField(email);
        registrationPage.fillPasswordField(passwordFiveSigns);
        registrationPage.pressRegistrationConfirmButton();

        registrationPage.passwordErrorVisible();
    }
}
