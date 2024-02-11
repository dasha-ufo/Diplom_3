package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
        switch (System.getProperty("browser","chrome")) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver","src/main/resources/yandexdriver");
                return new ChromeDriver();
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}