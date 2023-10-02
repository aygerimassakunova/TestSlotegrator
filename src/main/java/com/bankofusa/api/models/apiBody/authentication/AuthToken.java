package com.bankofusa.api.models.apiBody.authentication;

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
public class AuthToken extends RequestBody {
    @JsonProperty(value = "email")
    String email;
    @JsonProperty(value = "password")
    String password;
    @JsonProperty(value = "accessToken")
    String accessToken;
}
