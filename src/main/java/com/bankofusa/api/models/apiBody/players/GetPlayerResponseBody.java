package com.bankofusa.api.models.apiBody.players;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetPlayerResponseBody {
    @JsonProperty(value = "id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String id;
    @JsonProperty(value = "currency_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String currencyCode;
    @JsonProperty(value = "email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String email;
    @JsonProperty(value = "name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String name;
    @JsonProperty(value = "password_change")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String passwordChange;
    @JsonProperty(value = "password_repeat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String passwordRepeat;
    @JsonProperty(value = "surname")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String surname;
    @JsonProperty(value = "username")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String username;
}
