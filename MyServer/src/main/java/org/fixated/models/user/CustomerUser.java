package org.fixated.models.user;

public class CustomerUser extends User {
    @Override
    public String getRole(){
        return "CUSTOMER";
    }

    @Override
    public String getBranch() {
        return null;
    }

    @Override
    public String getWorkerID() {
        return "";
    }

    @Override
    public String getPhoneNumber() {
        return "";
    }

}
