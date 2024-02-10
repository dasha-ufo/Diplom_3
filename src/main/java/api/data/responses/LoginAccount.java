package api.data.responses;

import api.data.pojo.RegistrationBodyForm;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginAccount extends RestClient {
    public static final String ACCOUNT_LOGIN = "/api/auth/login";

    @Step("Отправка запроса на авторизацию для получения токена")
    public Response loginRequest(RegistrationBodyForm registrationBodyForm){
        return getDefaultRequestSpecification()
                .body(registrationBodyForm)
                .when()
                .post(ACCOUNT_LOGIN);
    }

    @Step("Проверяем ошибку 401 при авторизации с неверным логином или паролем")
    public void checkWrongEmailOrPassword(Response apiResponse){
        apiResponse.then().body("success", equalTo(false))
                .body("message", equalTo( "email or password are incorrect"))
                .statusCode(401);
    }
}
