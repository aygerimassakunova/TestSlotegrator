package com.bankofusa.api.models.players;

import com.bankofusa.api.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayersResponseBody extends BaseModel {

    @JsonProperty(value = "access_token")
    String token;
    @JsonProperty(value = "token_type")
    String typeOfToken;
    @JsonProperty(value = "expires_in")
    String expiresDate;
    @JsonProperty(value = "scope")
    String scope;
}
