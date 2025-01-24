package org.fixated.models.user;

public class ManagerUser extends User {
    @Override
    public Role getRole(){
        return Role.MANAGER;
    }
}
