package org.fixated.services;


import org.fixated.models.user.TableUser;
import org.fixated.repositories.UserJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class FindUserService {
    @Autowired
    private UserJpaDao userJpaDao;

    FindUserService(UserJpaDao userJpaDao) {
        this.userJpaDao = userJpaDao;
    }

    public List<TableUser> getAllManager(String role) {
        try {
            return userJpaDao.findAllByRole(role);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
