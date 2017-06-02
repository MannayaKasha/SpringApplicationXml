package org.mannayakasha.dao;

import org.mannayakasha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavel
 * @version 1.0
 */

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
