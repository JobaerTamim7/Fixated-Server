package org.fixated.services;

import org.fixated.models.request.auth.AuthRequest;
import org.fixated.models.request.auth.WorkerAuthRequest;
import org.fixated.models.user.User;
import org.fixated.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserDAO userDAO;

    @Autowired
    public LoginService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void userValidation(AuthRequest authRequest) throws Exception {
        User tempUser = userDAO.findUserByName(authRequest.getName());

        userValidation(tempUser);
        passwordValidation(tempUser, authRequest.getPassword());


        if (!(authRequest.getRole().equals("CUSTOMER"))) {
            roleValidation(authRequest.getRole(),tempUser.getRole());
            workerValidation((WorkerAuthRequest) authRequest, tempUser);
        }

    }
    private void userValidation(User user) throws Exception {
        if (user == null) {
            throw new IllegalArgumentException("Unregistered User");
        }
    }

    private void passwordValidation(User user,String password) throws Exception {
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Incorrect Password");
        }
    }

    private void roleValidation(String requestRole, String realRole) throws Exception {
        if (!requestRole.equals(realRole)) {
            throw new IllegalArgumentException("Roles do not match");
        }
    }

    private void workerValidation(WorkerAuthRequest authRequest, User user) throws Exception {

        boolean isEmpty =   authRequest.getPhoneNumber().isEmpty() ||
                            authRequest.getWorkerID().isEmpty() ||
                            authRequest.getBranchCode().isEmpty();
        if (isEmpty) {
            throw new IllegalArgumentException("Fill up the credentials");
        }

        boolean isOK =  authRequest.getBranchCode().equals(user.getBranch()) &&
                        authRequest.getWorkerID().equals(user.getWorkerID()) &&
                        authRequest.getPhoneNumber().equals(user.getPhoneNumber());

        if (!isOK) {
            throw new IllegalArgumentException("Wrong Credentials");
        }
    }

}
