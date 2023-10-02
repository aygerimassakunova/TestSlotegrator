package tests;

import com.bankofusa.api.ApiRequest;
import com.bankofusa.api.controller.Players;
import com.bankofusa.api.models.authentication.AuthenticationResponseBody;
import com.bankofusa.api.models.players.PlayersRequestBody;
import com.bankofusa.api.models.players.PlayersResponseBody;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.internal.path.json.mapping.JsonPathGsonObjectDeserializer;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static com.bankofusa.api.application.BaseEndPoints.*;

public class UserGetTest extends BaseApiTest{

    @Test
    public  void getUsers(){
        PlayersRequestBody playersRequestBody = PlayersRequestBody.builder()
                .name("Asan")
                .currency_code("USD")
                .email("asan@gmail.com")
                .password_change("hjbj")
                .password_repeat("hjbj")
                .surname("ghhf")
                .username("asanUhj")
                .build();

        System.out.println(playersRequestBody);
        Players players1 = new Players(BASE_URL);
        AuthenticationResponseBody responseBody = players1.createUser(playersRequestBody);
        System.out.println(responseBody);
        System.out.println(players1.getAllUsers()
                .prettyPrint());
    }

}
