package org.fixated.services;


import org.fixated.models.user.CustomerUser;
import org.fixated.models.user.User;
import org.fixated.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    private final UserDAO userDAO;

    @Autowired
    public SignupService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addCustomerUser(User user) throws Exception {
            if (!(user instanceof CustomerUser)){
                throw new IllegalArgumentException("Executive and Employee users are not supported");
            }
            userDAO.insertUser(user);
    }

    public void addWorkerUser(User user) throws Exception {
        if (user instanceof CustomerUser){
            throw new IllegalArgumentException("Something is fishy with the request");
        }
        userDAO.insertUser(user);
    }
}
