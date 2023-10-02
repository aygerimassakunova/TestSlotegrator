package com.bankofusa.api.controller;

import com.bankofusa.api.ApiRequest;
import com.bankofusa.api.models.apiBody.players.GetPlayerResponseBody;
import com.bankofusa.api.models.apiBody.players.PlayersRequestBody;
import com.bankofusa.api.models.apiBody.players.PlayersResponseBody;
import io.restassured.response.Response;

import static com.bankofusa.api.application.BaseEndPoints.*;
import static com.bankofusa.api.application.BaseEndPoints.CREATE;

public class PlayerController extends ApiRequest {
    public PlayerController(String url) {
        super(url);
    }

    public PlayersResponseBody createPlayer(PlayersRequestBody body) {
        return super.post(getEndPoint(API, AUTOMATION_TASK, CREATE), body.convertToString()).as(PlayersResponseBody.class);
    }

    public GetPlayerResponseBody getOneUserByEmail(String email) {
        PlayersRequestBody playersRequestBody = new PlayersRequestBody(email);
        return super.post(getEndPoint(API, AUTOMATION_TASK, GET_ONE), playersRequestBody.convertToString()).as(GetPlayerResponseBody.class);
    }

    public GetPlayerResponseBody[] getAllUsers() {
        return super.get(getEndPoint(API, AUTOMATION_TASK, GET_ALL)).as(GetPlayerResponseBody[].class);
    }

    public Response deletePlayer(String id) {
        return this.response = super.delete(getEndPoint(API, AUTOMATION_TASK, DELETE_USER, id));
    }
}
