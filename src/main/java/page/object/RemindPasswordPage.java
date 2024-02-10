package page.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RemindPasswordPage {
    private WebDriver driver;
    public RemindPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    private By enterButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and (contains(text(),'Войти'))]");
    private By repairButton = By.cssSelector(".button_button__33qZ0");
    private By emailField = By.className("Auth_fieldset__1QzWN mb-6");

    @Step("Нажимаем кнопку Войти")
    public void pressEnterButton() {
        driver.findElement(enterButton).click();
    }
    @Step("Нажимаем кнопку Восстановить")
    public void pressRepairButton() {
        driver.findElement(repairButton).click();
    }
    @Step("Заполняем поле email")
    public void fillEmail() {
        driver.findElement(emailField).sendKeys();
    }
}
