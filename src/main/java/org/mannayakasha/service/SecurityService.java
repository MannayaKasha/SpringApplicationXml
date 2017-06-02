package org.mannayakasha.service;

/**
 * @author Pavel
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
