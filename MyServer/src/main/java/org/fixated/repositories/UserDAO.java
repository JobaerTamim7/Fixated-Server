package org.fixated.repositories;

import org.fixated.models.user.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    private final JdbcTemplate template;

    public UserDAO(JdbcTemplate template){
        this.template = template;
    }

    public List<User> findAllUser(){
        String sql = "SELECT * FROM  users";
        return template.query(sql,new UserRowMapper());
    }

    public User findUserByMail(String mail){
        try{
            String sql = "SELECT * FROM users WHERE mail = ?";
            return template.queryForObject(sql,new UserRowMapper(),mail);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }

    }
}
