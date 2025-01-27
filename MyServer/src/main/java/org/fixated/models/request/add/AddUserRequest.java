package org.fixated.models.request.add;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = CustomerAddRequest.class, name = "customer"),
        @JsonSubTypes.Type(value = WorkerAddRequest.class, name = "worker")
})

public class AddUserRequest {
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("role")
    private String role;

    public AddUserRequest(String userName, String password, String mail, String role) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AddUserRequest [userName=" + userName + ", password=" + password + ", mail=" + mail + ", role=" + role + "]";
    }

}
