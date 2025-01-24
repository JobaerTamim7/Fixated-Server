package org.fixated.repositories;

import org.fixated.models.user.User;
import org.fixated.models.user.UserFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UserFactory.getUser(rs);
    }
}
