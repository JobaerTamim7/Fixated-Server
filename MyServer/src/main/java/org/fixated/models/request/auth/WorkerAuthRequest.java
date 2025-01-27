package org.fixated.models.request.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class WorkerAuthRequest extends AuthRequest {
    private String phoneNumber;
    private String workerID;
    private String branchCode;

    @JsonCreator
    public WorkerAuthRequest(
            @JsonProperty("user_name") String name,
            @JsonProperty("password") String password,
            @JsonProperty("role") String role,
            @JsonProperty("phone_no") String phoneNumber,
            @JsonProperty("worker_id") String workerID,
            @JsonProperty("branch_code") String branchCode) {
        super(name, password, role);
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
        return super.toString() + "Subclass : WorkerAuthRequest [phoneNumber=" + phoneNumber + ", workerID=" + workerID + ", branchCode=" + branchCode + "]";
    }

}
