package com.bankofusa.api.models.apiBody.authentication;
import com.bankofusa.api.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper=false)

public class AuthenticationResponseBody extends BaseModel {
    @JsonProperty(value = "id")
    int idNumber;
    @JsonProperty(value = "username")
    String userName;
    @JsonProperty(value = "email")
    String eMail;
    @JsonProperty(value = "name")
    String name;
    @JsonProperty(value = "surname")
    String surName;
}
