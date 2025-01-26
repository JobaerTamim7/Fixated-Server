package org.fixated.models.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerAuthRequest extends AuthRequest{

    @JsonCreator
    public CustomerAuthRequest(
            @JsonProperty("user_name") String name,
            @JsonProperty("password") String password,
            @JsonProperty("role") String role) {
        super(name, password, role);
    }
}
