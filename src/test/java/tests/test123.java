package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

@Slf4j
public class test123 {
    @Test
    void gptTest(){
        String body = "{\n" +
                "  \"email\": \"aassakunova@gmail.com\",\n" +
                "  \"password\": \"JPwK4CTxAwAL\"\n" +
                "}";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .when()
                .post("https://testslotegrator.com/api/tester/login")
                .then().log().all()
                .extract().response();
            String response1 = response.getBody().asString();
            JSONObject responseBody = new JSONObject(response1);
            String token = responseBody.getString("accessToken");
            System.out.println(token);
    }
}
