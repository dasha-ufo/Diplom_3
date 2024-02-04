package testDataCreateApi.apiResponses;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import testDataCreateApi.pojo.RegistrationBodyForm;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

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

    @Step("Проверка успешного ответа об удалении со статусом 202")
    public static void checkSuccessDelete(Response apiResponse){
        apiResponse.then().body("success", equalTo(true))
                .statusCode(202);
    }



}
