package com.bankofusa.api.models;

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
public class Player {
    String id;
    String currencyCode;
    String email;
    String name;
    String passwordChange;
    String passwordRepeat;
    String surname;
    String username;
    String v;
}
