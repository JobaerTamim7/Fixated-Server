package org.fixated.models.user;

public class CustomerUser extends User {
    @Override
    public Role getRole(){
        return Role.CUSTOMER;
    }
}
