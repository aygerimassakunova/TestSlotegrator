package com.bankofusa.api.asserts;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
@Slf4j
public class ApiAssert {
    Response response;
    public ApiAssert(Response response){
        this.response = response;
    }
    public static ApiAssert assertThat(Response response){
        return new ApiAssert(response);
    }
    public ApiAssert isCorrectStatusCode(Integer expectedStatusCode){
        int actualStatusCode=this.response.getStatusCode();
        Assertions.assertThat(actualStatusCode)
                .withFailMessage("Status code is not correct")
                .isEqualTo(expectedStatusCode);
                 log.info("Status code is correct. Actual {}, Expected {}", actualStatusCode, expectedStatusCode);
        return this;
    }
    public ApiAssert isNotNull(String token){
        Assertions.assertThat(this.response.getBody().asString().contains(token));
        return this;
    }

        }
