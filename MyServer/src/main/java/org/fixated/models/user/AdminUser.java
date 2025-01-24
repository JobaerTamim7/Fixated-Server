package org.fixated.models.user;

public class AdminUser extends User {
    @Override
    public Role getRole(){
        return Role.ADMIN;
    }
}
