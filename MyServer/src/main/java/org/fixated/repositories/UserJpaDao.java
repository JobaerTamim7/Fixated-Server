package org.fixated.repositories;


import org.fixated.models.user.TableUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserJpaDao extends JpaRepository<TableUser,Integer> {
    public List<TableUser> findAllByRole(String role);
}
