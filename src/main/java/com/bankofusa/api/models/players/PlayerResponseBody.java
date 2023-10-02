package com.bankofusa.api.models.players;
import com.bankofusa.api.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper=false)

public class PlayerResponseBody extends BaseModel {
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
