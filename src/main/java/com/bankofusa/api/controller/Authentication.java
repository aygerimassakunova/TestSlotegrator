package com.bankofusa.api.controller;
import com.bankofusa.api.models.authentication.AuthenticationRequestBody;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import static com.bankofusa.api.application.BaseEndPoints.BASE_URL;
import static com.bankofusa.api.application.BaseEndPoints.TESTERLOGIN;
import static io.restassured.RestAssured.given;
@Data
public class Authentication {
    protected String url;
    protected RequestSpecification requestSpecification;
    protected String accessToken;
    public Authentication(String email, String password){
        AuthenticationRequestBody body = AuthenticationRequestBody.builder()
                .email(email)
                .password(password)
                .build();
        this.accessToken = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(BASE_URL + "/"+ TESTERLOGIN)
                .then().log().all()
                .extract().response()
                .jsonPath().getString("accessToken");
    }
}
