package org.fixated.repositories;

import org.fixated.models.user.User;
import org.springframework.dao.DuplicateKeyException;
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

    public User findUserByName(String name){
        try{
            String sql = "SELECT * FROM users WHERE name = ?";
            return template.queryForObject(sql,new UserRowMapper(),name);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    private boolean checkUserExists(String name){
        String sql = "SELECT COUNT(*) FROM  users WHERE name = ?";
        Integer count = template.queryForObject(sql,Integer.class,name);
        return count > 0;
    }

    private boolean checkMailExists(String mail){
        String sql = "SELECT COUNT(*) FROM  users WHERE mail = ?";
        Integer count = template.queryForObject(sql,Integer.class,mail);
        return count > 0;
    }

    public void insertUser(User user) throws DuplicateKeyException{
        String sql = "INSERT INTO users " +
                "(mail, name, password, role, phone_number, worker_id, branch_code) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            if(checkMailExists((user.getMail().toLowerCase()))){

                throw new DuplicateKeyException("User with this mail already exists");
            }
            if (checkUserExists(user.getName().toLowerCase())){
                throw new DuplicateKeyException("User with this name already exists");
            }

            template.update(sql,
                    user.getMail().toLowerCase(),
                    user.getName(),
                    user.getPassword(),
                    user.getRole().toLowerCase(),
                    user.getPhoneNumber(),
                    user.getWorkerID(),
                    user.getBranch());

        }
        catch (Exception e){
            System.out.println(e.getMessage()) ;
            throw e;
        }
    }
}
