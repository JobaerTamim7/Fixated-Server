package org.fixated.models.request.add;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerAddRequest extends AddUserRequest {

    @JsonCreator
    public CustomerAddRequest(@JsonProperty("user_name") String userName,
                              @JsonProperty("password") String password,
                              @JsonProperty("mail") String mail,
                              @JsonProperty("role") String role) {
        super(userName, password, mail, role);
    }

    @Override
    public String toString() {
        return super.toString() + "Subclass : CustomerAddRequest";
    }
}
