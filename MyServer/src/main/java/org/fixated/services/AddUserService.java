package org.fixated.services;

import org.fixated.models.request.add.AddTempUserRequest;
import org.fixated.models.request.add.WorkerAddRequest;
import org.fixated.models.user.User;
import org.fixated.models.user.UserFactory;
import org.fixated.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AddUserService {
    private UserDAO userDAO;

    @Autowired
    public AddUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addTempUser(AddTempUserRequest tempUserRequest) throws SQLException {
        try {
            User user = UserFactory.getUser(tempUserRequest);
            userDAO.addTempWorkerUser(user);
        } catch (Exception e) {
            throw e;
        }
    }

    public void validateTempUser(AddTempUserRequest tempUserRequest) throws SQLException {
        try {
            User user = UserFactory.getUser(tempUserRequest);
            userDAO.validateTempWorker(user);
        } catch (Exception e) {
            throw e;
        }
    }
}
