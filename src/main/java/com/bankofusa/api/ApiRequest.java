package com.bankofusa.api;

import com.bankofusa.api.models.BaseModel;
import com.bankofusa.api.models.apiBody.authentication.AuthToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.bankofusa.api.application.BaseEndPoints.*;
import static io.restassured.RestAssured.given;

@Slf4j
public abstract class ApiRequest {
    protected String url;
    protected RequestSpecification requestSpecification;
    protected Response response;

    public ApiRequest(String url) {
        this.url = url;
        this.requestSpecification = given()
                .baseUri(this.url)
                .auth()
                .preemptive()
                .oauth2(getBearerToken());
    }

    private String getBearerToken() {
        AuthToken authToken = new AuthToken();
        authToken.setEmail("aassakunova@gmail.com");
        authToken.setPassword("JPwK4CTxAwAL");
        return auth(getEndPoint(API, TESTER, LOGIN), authToken.convertToString()).as(AuthToken.class).getAccessToken();
    }

    private Response auth(String endPoint, String body) {
        log.info("Performed POST {} {}", this.url, endPoint);
        log.info("Body is {}", body);
        this.response = given()
                .baseUri(this.url)
                .contentType(ContentType.JSON)
                .body(body)
                .post(endPoint);
        logResponse();
        return this.response;
    }

    public static String getEndPoint(String... args) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(args).forEach(
                a -> builder.append(a).append("/")
        );
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    private void logResponse() {
        log.warn("Response is: ");
        log.warn(this.response.getBody().asString());
        log.warn("Status code is: {}", this.response.getStatusCode());
    }

    protected Response get(String endPoint) {
        log.info("Performed GET {}", endPoint);
        this.response = given()
                .spec(this.requestSpecification)
                .get(endPoint);
        logResponse();
        return this.response;
    }


    protected Response delete(String endPoint) {
        log.info("Performed DELETE {}", endPoint);
        this.response = given()
                .spec(this.requestSpecification)
                .delete(endPoint);
        logResponse();
        return this.response;
    }


    protected Response post(String endPoint, String body) {
        log.info("Performed POST {}", endPoint);
        log.info("Body is {}", body);
        this.response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .spec(requestSpecification)
                .body(body)
                .post(endPoint);
        logResponse();
        return this.response;
    }


    public <T extends BaseModel> T extractObjectFromResponse(Class<T> tClass) {
        try {
            return this.response
                    .then()
                    .extract()
                    .body()
                    .as(tClass);
        } catch (Exception e) {
            log.error("Cannot parse response {0}", e);
            return null;
        }
    }
}




    

