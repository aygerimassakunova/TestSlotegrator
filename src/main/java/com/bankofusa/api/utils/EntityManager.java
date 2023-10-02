package com.bankofusa.api.utils;

import com.bankofusa.api.models.apiBody.players.PlayersRequestBody;

public class EntityManager {
    public static PlayersRequestBody generatePlayerRequest() {
        final String pass = MockData.generatePassword();
        return PlayersRequestBody.builder()
                .currencyCode(MockData.generateCurrency())
                .email(MockData.generateEmail())
                .name(MockData.generateName())
                .passwordChange(pass)
                .passwordRepeat(pass)
                .surname(MockData.generateName())
                .userName(MockData.generateName())
                .build();
    }
}
