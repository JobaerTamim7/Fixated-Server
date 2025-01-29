package org.fixated.repositories;

import org.fixated.models.user.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {
    private final JdbcTemplate template;

    public UserDAO(JdbcTemplate template){
        this.template = template;
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

    private boolean checkUserExists(String name, String table){
        List<String> tables = List.of("users","temp_users");
        if(!tables.contains(table)){
            throw new IllegalArgumentException("Table " + table + " does not exist");
        }
        String sql = String.format("SELECT COUNT(*) FROM %s WHERE name LIKE ?", table);
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
            if (checkUserExists(user.getName().toLowerCase(),"users")){
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
            throw e;
        }
    }

    public void addTempWorkerUser(User user){
        String sql = "INSERT INTO temp_users "+
                "(branch_id, role, name, worker_id) "+
                "VALUES (?, ?, ?, ?)";
        try {
            if (checkUserExists(user.getName().toLowerCase(),"temp_users")){
                throw new DuplicateKeyException("User with this name already exists");
            }
            template.update(sql,
                        user.getBranch(),
                        user.getRole().toLowerCase(),
                        user.getName().toLowerCase(),
                        user.getWorkerID()
                    );
        } catch (Exception e){
            throw e;
        }

    }


    public void validateTempWorker(User user){
        String sql = "SELECT COUNT(*) FROM temp_users WHERE branch_id = ? AND role = ? AND name = ? AND worker_id = ?";
        String delete = "DELETE FROM temp_users WHERE branch_id = ? AND role = ? AND name = ? AND worker_id = ?";
        try {
            int count = template.queryForObject(sql,Integer.class,user.getBranch(),user.getRole().toLowerCase(),user.getName(), user.getWorkerID());
            if (count == 0){
                throw new DuplicateKeyException("Not valid credentials");
            }
            template.update(delete,
                    user.getBranch(),
                    user.getRole().toLowerCase(),
                    user.getName(),
                    user.getWorkerID());

        } catch (Exception e){
            throw e;
        }
    }
}
