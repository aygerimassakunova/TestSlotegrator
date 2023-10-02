package com.bankofusa.api;
import com.bankofusa.api.controller.Authentication;
import com.bankofusa.api.models.BaseModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import static io.restassured.RestAssured.given;
@Slf4j
public abstract class ApiRequest {
    protected String url;
    protected RequestSpecification requestSpecification;
    protected Response response;
    public ApiRequest(String url) {
        this.url = url;
        Authentication authToken = new Authentication("aassakunova@gmail.com", "JPwK4CTxAwAL");
        this.requestSpecification = given()
                .auth()
                .preemptive()
                .oauth2(authToken.getAccessToken());
                //.contentType(ContentType.JSON)
                //.header("Authorization", "Bearer " + authToken.getAccessToken());
        this.requestSpecification.log().all();
    }
   /* public String getBearerToken(){

    }*/
    public static String getEndPoint(String...args){
        StringBuilder builder = new StringBuilder();
        Arrays.stream(args).forEach(
                a -> builder.append(a).append("/")
        );
        return builder.deleteCharAt(builder.length()-1).toString();
    }
    private void logResponse(){
        log.warn("Response is: ");
        log.warn(this.response.getBody().asString());
        log.warn("Status code is: {}", this.response.getStatusCode());
}
    public Response get(String endPoint){
        log.info("Performed GET {}", endPoint);
        this.response = given()
                .spec(this.requestSpecification)
                .get(endPoint);
        return this.response;
    }
    public Response deleteById(String endPoint, int id){
        log.info("Performed GET {}", id);
        this.response = given()
                .spec(this.requestSpecification)
                .delete(endPoint);
        return this.response;
    }
public Response post(String endPoint, String body){
        log.info("Performed POST {}", endPoint);
        log.info("Body is {}", body);
        this.response = RestAssured
                .given()
                .spec(requestSpecification)
                .body(body)
                .post(endPoint);
        logResponse();
        return this.response;
}
    public Response getWithParam(String endPoint, String param){
        log.info("Performed POST {}", endPoint);
        this.response = given()
                .spec(this.requestSpecification)
                .param(param)
                .post(endPoint);
        logResponse();
        return this.response;
    }
    public <T extends BaseModel> T extractObjectFromResponse(Class<T>tClass){
        try{
        return this.response
                .then()
                .extract()
                .body()
                .as(tClass);
    } catch (Exception e){
            log.error("Cannot parse response {0}", e);
            return null;
        }}}




    

