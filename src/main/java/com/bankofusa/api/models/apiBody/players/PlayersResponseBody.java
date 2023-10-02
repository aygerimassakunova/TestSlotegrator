package com.bankofusa.api.models.apiBody.players;

import com.bankofusa.api.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayersResponseBody extends BaseModel {
    @JsonProperty(value = "_id")
    String id;
    @JsonProperty(value = "currency_code")
    String currencyCode;
    @JsonProperty(value = "email")
    String email;
    @JsonProperty(value = "name")
    String name;
    @JsonProperty(value = "password_change")
    String passwordChange;
    @JsonProperty(value = "password_repeat")
    String passwordRepeat;
    @JsonProperty(value = "surname")
    String surname;
    @JsonProperty(value = "username")
    String username;
    @JsonProperty(value = "__v")
    String v;
}
