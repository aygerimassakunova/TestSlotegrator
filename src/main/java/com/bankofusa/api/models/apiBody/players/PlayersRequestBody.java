package com.bankofusa.api.models.apiBody.players;

import com.bankofusa.api.RequestBody;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayersRequestBody extends RequestBody {
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
    String userName;

    public PlayersRequestBody(String email) {
        this.email = email;
    }
}

