package org.fixated.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = CustomerAuthRequest.class, name = "customer"),
        @JsonSubTypes.Type(value = WorkerAuthRequest.class, name = "worker")
})


public abstract class AuthRequest {
    @JsonProperty("user_name")
    private String name;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private String role;

    public AuthRequest(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthRequest [name=" + name + ", password=" + password + ", role=" + role + "]";
    }
}

