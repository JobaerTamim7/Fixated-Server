package org.fixated.models.user;

public class EmployeeUser extends User {
    @Override
    public Role getRole(){
        return Role.EMPLOYEE;
    }
}
