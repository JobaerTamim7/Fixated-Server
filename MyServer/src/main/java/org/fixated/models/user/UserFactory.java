package org.fixated.models.user;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFactory {
    public static User getUser(ResultSet resultSet) throws SQLException {
        Role role = Role.valueOf(resultSet.getString("role").toUpperCase());
        User user = switch (role) {
            case ADMIN -> new AdminUser();
            case MANAGER -> new ManagerUser();
            case EMPLOYEE -> new EmployeeUser();
            case CUSTOMER -> new CustomerUser();
            default -> throw new IllegalArgumentException("Unknown Role " + role);
        };
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setMail(resultSet.getString("mail"));
        user.setPassword(resultSet.getString("password"));
        user.setRole();
        return user;
    }
}
