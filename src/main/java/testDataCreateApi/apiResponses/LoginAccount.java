package testDataCreateApi.apiResponses;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import testDataCreateApi.pojo.RegistrationBodyForm;

public class LoginAccount extends RestClient {
    public static final String ACCOUNT_LOGIN = "/api/auth/login";

    @Step("Отправка запроса на авторизацию для получения токена")
    public Response loginRequest(RegistrationBodyForm registrationBodyForm){
        return getDefaultRequestSpecification()
                .body(registrationBodyForm)
                .when()
                .post(ACCOUNT_LOGIN);
    }

}
