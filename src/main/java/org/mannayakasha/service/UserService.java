package org.mannayakasha.service;

import org.mannayakasha.model.User;

/**
 * @author Pavel
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
