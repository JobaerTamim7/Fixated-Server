package org.fixated.models.user;

import org.fixated.models.request.add.AddUserRequest;
import org.fixated.models.request.add.CustomerAddRequest;
import org.fixated.models.request.add.WorkerAddRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFactory {

    private static User createUserFromRole(String role) throws SQLException,IllegalArgumentException {
        User user = switch (role) {
            case "ADMIN" -> new AdminUser();
            case "MANAGER" -> new ManagerUser();
            case "EMPLOYEE" -> new EmployeeUser();
            case "CUSTOMER" -> new CustomerUser();
            default -> throw new IllegalArgumentException("Unknown Role " + role);
        };
        return user;
    }

    public static User getUser(ResultSet resultSet) throws SQLException {
        String role = resultSet.getString("role").toUpperCase();
        User user = createUserFromRole(role);
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setMail(resultSet.getString("mail"));
        user.setPassword(resultSet.getString("password"));
        if (!(user instanceof CustomerUser)) {
            user.setWorkerID(resultSet.getString("worker_id"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setBranch(String.valueOf(resultSet.getInt("branch_code")));
        }
        user.setRole();
        return user;
    }


    public static User getUser(AddUserRequest addUserRequest) throws SQLException {
        String role = addUserRequest.getRole();
        User user = createUserFromRole(addUserRequest.getRole());

        user.setName(addUserRequest.getUserName());
        user.setMail(addUserRequest.getMail());
        user.setPassword(addUserRequest.getPassword());
        if (!(user instanceof CustomerUser) && addUserRequest instanceof WorkerAddRequest) {
            user.setWorkerID(((WorkerAddRequest) addUserRequest).getWorkerID());
            user.setPhoneNumber(((WorkerAddRequest) addUserRequest).getPhoneNumber());
            user.setBranch(((WorkerAddRequest) addUserRequest).getBranchCode());
            System.out.println(user.getBranch());
        }
        user.setRole();

        return user;
    }
}
