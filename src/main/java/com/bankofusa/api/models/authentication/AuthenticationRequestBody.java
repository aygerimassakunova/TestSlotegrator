package com.bankofusa.api.models.authentication;
import com.bankofusa.api.models.BaseModel;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AuthenticationRequestBody extends BaseModel {
    String email;
    String password;
}
