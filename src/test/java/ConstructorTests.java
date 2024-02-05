import factoryBrowsers.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjeckts.ConstructorMainPage;

public class ConstructorTests {
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
    @DisplayName("Проверяем работу таба Соусы")
    @Description("Нажимаем на таб соусы и проверяем, что секция видна и таб стал активным")
    public void sousesTabCheck() {
        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.goToMainPage();

        constructorMainPage.blockTabIsVisible();
        constructorMainPage.clickSousesTab();
        constructorMainPage.sousesSectionIsVisible();
        constructorMainPage.sousesTabActiveCheck();
    }

    @Test
    @DisplayName("Проверяем работу таба Начинки")
    @Description("Нажимаем на таб начинки и проверяем, что секция видна и таб стал активным")
    public void nachinkiTabCheck() {
        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.goToMainPage();

        constructorMainPage.blockTabIsVisible();
        constructorMainPage.clickNachinkiTab();
        constructorMainPage.nachinkiSectionIsVisible();
        constructorMainPage.nachinkiTabActiveCheck();
    }

    @Test
    @DisplayName("Проверяем работу таба Булки")
    @Description("Нажимаем на таб начинки, затем на таб булки и проверяем, что секция видна и таб стал активным")
    public void bulkiTabCheck() {
        ConstructorMainPage constructorMainPage = new ConstructorMainPage(driver);
        constructorMainPage.goToMainPage();

        constructorMainPage.blockTabIsVisible();
        constructorMainPage.clickNachinkiTab();
        constructorMainPage.nachinkiSectionIsVisible();
        constructorMainPage.nachinkiTabActiveCheck();

        constructorMainPage.clickBulkiTab();
        constructorMainPage.bulkiSectionIsVisible();
        constructorMainPage.bulkiTabActiveCheck();
    }
}
