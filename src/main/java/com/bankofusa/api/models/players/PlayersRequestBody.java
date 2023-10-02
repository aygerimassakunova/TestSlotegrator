package com.bankofusa.api.models.players;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayersRequestBody {
    String currency_code;
    String email;
    String name;
    String password_change;
    String password_repeat;
    String surname;
    String username;

    @Override
    public String toString() {
        return "{" +
                "currency_code='" + currency_code + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password_change='" + password_change + '\'' +
                ", password_repeat='" + password_repeat + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

