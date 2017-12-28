package com.helloword.security;

import org.springframework.stereotype.Service;

/**
 * Created by scnyig on 12/28/2017.
 */

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
