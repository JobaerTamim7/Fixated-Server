package org.fixated.models.user;

public class ManagerUser extends User {
    private String workerID;
    private String branchCode;
    private String phoneNumber;

    @Override
    public String getRole(){
        return "MANAGER";
    }

    @Override
    public String getWorkerID(){
        return workerID;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public void setBranchCode(String BranchCode) {
        this.branchCode = BranchCode;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getBranch() {
        return this.branchCode;
    }

    @Override
    public void setBranch(String branchCode) {
        this.branchCode = branchCode;
    }
}
