import factory.browsers.ChooseBrowser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.object.ConstructorMainPage;
import page.object.Header;
import page.object.LoginPage;
import page.object.RegistrationPage;
import api.data.responses.DeleteAccount;

public class RegistrationTest {

    private WebDriver driver;
    private String email;
    private String password;
    private String name;

    @Before
    public void startUp() {
        driver = ChooseBrowser.chooseWebDriver();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проходим успешный сценарий регистрации и оказываемся на странице залогина")
    public void checkSuccessRegistration() throws InterruptedException {
        name = RandomStringUtils.randomAlphabetic(8);
        email = RandomStringUtils.randomAlphabetic(6) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(6);

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

        loginPage.enterSectionIsVisible();

        DeleteAccount.deleteWithCheckStatus200(email, password);
    }

     @Test
    @DisplayName("Ошибка при регистрации с паролем менее 6 символов")
    @Description("При регистрации вводим пароль 5 символов и проверяем отображение ошибки")
    public void wrongPasswordRegistratoin() {
        name = RandomStringUtils.randomAlphabetic(8);
        email = RandomStringUtils.randomAlphabetic(6) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(5);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToRegistrationPage();
        registrationPage.fillNameField(name);
        registrationPage.fillEmailField(email);
        registrationPage.fillPasswordField(password);
        registrationPage.pressRegistrationConfirmButton();

        registrationPage.passwordErrorVisible();

        DeleteAccount.deleteWitEmptyAccessToken(email, password);
    }
}
