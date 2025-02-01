package org.fixated.models.request.add;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkerAddRequest extends AddUserRequest{
    private String phoneNumber;
    private String workerID;
    private String branchCode;

    @JsonCreator
    public WorkerAddRequest(
            @JsonProperty("user_name") String name,
            @JsonProperty("password") String password,
            @JsonProperty("mail") String mail,
            @JsonProperty("role") String role,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("worker_id") String workerID,
            @JsonProperty("branch_code") String branchCode
    ) {
        super(name, password, mail, role);
        this.phoneNumber = phoneNumber;
        this.workerID = workerID;
        this.branchCode = branchCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return super.toString() + "Subclass : WorkerAddRequest [phoneNumber=" + phoneNumber + ", workerID=" + workerID + ", branchCode=" + branchCode + "]";
    }
}
