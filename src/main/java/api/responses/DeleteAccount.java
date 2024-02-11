package api.responses;

import api.pojo.RegistrationBodyForm;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteAccount extends RestClient {

    public static final String ACCOUNT_INFO_UPDATE = "/api/auth/user";


    @Step("Удаляем пользователя и проверяем успешный ответ 202")
    public static void deleteUserRequestWithToken(Response apiResponse) {
        String accessToken = apiResponse.then()
                .extract()
                .jsonPath()
                .getString("accessToken");
        Response deleteResponse = given()
                .baseUri(RestConfig.BASE_URI)
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .when()
                .delete(ACCOUNT_INFO_UPDATE);
        DeleteAccount.checkSuccessDelete(deleteResponse);
    }

    @Step("Удаляем пользователя без проверки успешного ответа")
    public static void deleteUserWithTokenNoCheck(Response apiResponse) {
        String accessToken = apiResponse.then()
                .extract()
                .jsonPath()
                .getString("accessToken");
        Response deleteResponse = given()
                .baseUri(RestConfig.BASE_URI)
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .when()
                .delete(ACCOUNT_INFO_UPDATE);
    }

    @Step("Проверка успешного ответа об удалении со статусом 202")
    public static void checkSuccessDelete(Response apiResponse){
        apiResponse.then().body("success", equalTo(true))
                .statusCode(202);
    }

    @Step("Пытаемся удалить пользователя и проверяем, что вернулась ошибка при логине")
    public static void deleteWitEmptyAccessToken(String email, String password){
    RegistrationBodyForm registrationBodyForm = new RegistrationBodyForm(email, password);
    LoginAccount loginAccount = new LoginAccount();
    Response userForDelete = loginAccount.loginRequest(registrationBodyForm);
    loginAccount.checkWrongEmailOrPassword(userForDelete);
    }

    @Step("Логинимся и удаляем пользователя c проверкой на успех")
    public static void deleteWithCheckStatus200(String email, String password){
        RegistrationBodyForm registrationBodyForm = new RegistrationBodyForm(email, password);
        LoginAccount loginAccount = new LoginAccount();
        Response userForDelete = loginAccount.loginRequest(registrationBodyForm);
        deleteUserRequestWithToken(userForDelete);
    }
}
