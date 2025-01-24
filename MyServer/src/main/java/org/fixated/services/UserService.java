package org.fixated.services;

import org.fixated.models.user.User;
import org.fixated.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userRepository;

    @Autowired
    public UserService(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    public void authUser(String mail, String password) throws Exception {
        User tempUser = userRepository.findUserByMail(mail);
        if (tempUser == null){
            throw new IllegalArgumentException("Unregistered User");
        }
        else if (!tempUser.getPassword().equals(password)) {
            throw new IllegalArgumentException("Incorrect Password");
        }
    }
}
