package api.responses;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import api.pojo.RegistrationBodyForm;

public class RegisterAccount extends RestClient {
    public static final String ACCOUNT_REGISTER = "/api/auth/register";

    @Step("Отправка запроса для регистрации пользователя /api/auth/register с заполненным телом")
    public Response create (RegistrationBodyForm registrationBodyForm) {
        return getDefaultRequestSpecification()
                .body(registrationBodyForm)
                .when()
                .post(ACCOUNT_REGISTER);
    }
}

