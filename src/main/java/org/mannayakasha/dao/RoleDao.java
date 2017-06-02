package org.mannayakasha.dao;

import org.mannayakasha.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavel
 * @version 1.0
 */

public interface RoleDao extends JpaRepository<Role, Long> {
}
