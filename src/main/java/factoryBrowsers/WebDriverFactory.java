package factoryBrowsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    /* public WebDriver getWebDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            default:
                return createChromeDriver();
        }
    }

    public WebDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriver createYandexDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/daricheban/WebDriver/bin/yandexdriver");
        ChromeOptions yandexOptions = new ChromeOptions();
        return new ChromeDriver(yandexOptions);
    }
} */

    public WebDriver getWebDriver() {
        switch (System.getProperty("browser")) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver","/Users/daricheban/Diplom_3/src/main/resources/yandexdriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}