package com.helloword.service;

import com.helloword.entity.User;
import com.helloword.security.UserDTO;

/**
 * Created by scnyig on 12/18/2017.
 */
public interface UserService {
    public UserDTO findUserByEmail(String email);
    public void saveUser(UserDTO user);
}
