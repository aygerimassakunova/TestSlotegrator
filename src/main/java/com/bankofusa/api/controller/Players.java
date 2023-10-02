package com.bankofusa.api.controller;
import com.bankofusa.api.ApiRequest;
import com.bankofusa.api.models.authentication.AuthenticationResponseBody;
import com.bankofusa.api.models.players.PlayersRequestBody;
import com.bankofusa.api.models.players.PlayersResponseBody;
import io.restassured.response.Response;
import static com.bankofusa.api.application.BaseEndPoints.*;
import static com.bankofusa.api.application.BaseEndPoints.CREATE;

public class Players extends ApiRequest {
    public Players(String url) {
        super(url);
    }
    public AuthenticationResponseBody createUser(PlayersRequestBody body){
     return super.post(getEndPoint(BASE_URL, AUTOMATION_TASK, CREATE), body.toString())
                .jsonPath()
                .getObject("", AuthenticationResponseBody.class);
    }

 /*   public Response generateUsers(int numberOfPlayers){
    return this.response =
            for(int i = 0; i<=numberOfPlayers; i++){
                createUser(generatePlayersData());
            }
    }*/

    public Response deleteUser(int id){

        return this.response = super.deleteById(getEndPoint(BASE_URL, AUTOMATION_TASK, DELETE_USER),id);

    }
    public Response getAllUsers(){

        return this.response = super.get(getEndPoint(BASE_URL, AUTOMATION_TASK, GET_ALL));
    }
    public Response getOneUser(String email){
    return this.response = super.getWithParam(getEndPoint(BASE_URL, GET_ONE), email);
    }


}
