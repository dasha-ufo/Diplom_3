import browsers.ChooseBrowser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.ConstructorMainPage;
import pageobject.Header;
import pageobject.LoginPage;
import pageobject.PersonalCabinetPage;
import api.responses.DeleteAccount;
import api.responses.RegisterAccount;
import api.pojo.RegistrationBodyForm;

public class PersonalCabinetTests {
        private WebDriver driver;
        private String email;
        private String password;
        private Response responseForDelete;
        private RegisterAccount registerAccount;
        private RegistrationBodyForm registrationBodyForm;


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
        @DisplayName("Переход в личный кабинет авторизованным пользователем")
        @Description("Проверяем отображение блоков личного кабинета под авторизованным пользователем")
        public void loginViaEnterToAccountButton() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.fullLogin(email,password);

            ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
            Header header = new Header(driver);
            constructorMainPage.mainPageIsVisible();
            header.pressPersonalCabinetButton();

            PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
            personalCabinetPage.isNavigationBlockVisible();
            personalCabinetPage.isContentBlockVisible();
            header.headerSectionIsVisible();
        }

    @Test
    @DisplayName("Переход из личного кабинета по кнопке конструктор")
    @Description("Нажимаем на кнопку конструктор из личного кабинета и проверяем отображение главной")
    public void checkConstructorButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fullLogin(email,password);
        loginPage.goToLoginPage();

        Header header = new Header(driver);
        header.pressOnConstructorButton();

        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.mainPageIsVisible();
    }

    @Test
    @DisplayName("Переход из личного кабинета по нажатию на логотип")
    @Description("Нажимаем на логотип из личного кабинета и проверяем отображение главной")
    public void checkLogoButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fullLogin(email,password);
        loginPage.goToLoginPage();

        Header header = new Header(driver);
        header.pressPersonalCabinetButton();
        header.pressOnLogotype();

        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.mainPageIsVisible();
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    @Description("Под авторизованным пользователем нажимаем «Выйти» в личном кабинете")
    public void exitFromPersonalCabinet() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fullLogin(email,password);

        Header header = new Header(driver);
        header.pressPersonalCabinetButton();

        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.pressExitButton();
        loginPage.enterSectionIsVisible();
    }
    }
