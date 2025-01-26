package org.fixated.models.user;

public class EmployeeUser extends User {
    private String workerID;
    private String branchCode;
    private String phoneNumber;

    @Override
    public String getRole(){
        return "EMPLOYEE";
    }


    @Override
    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    @Override
    public void setBranch(String BranchCode) {
        this.branchCode = BranchCode;
    }

    @Override
    public String getBranch() {
        return this.branchCode;
    }

    @Override
    public String getWorkerID() {
        return this.workerID;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
