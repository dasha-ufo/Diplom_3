package testDataCreateApi.apiResponses;

import io.restassured.specification.RequestSpecification;

import static testDataCreateApi.apiResponses.RestConfig.BASE_URI;
import static io.restassured.RestAssured.given;

public abstract class RestClient {

    public RequestSpecification getDefaultRequestSpecification(){
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json");
    }
}
