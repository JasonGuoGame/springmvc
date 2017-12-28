package com.helloword.service;

import com.helloword.dto.UserDTO;
import com.helloword.entity.User;

/**
 * Created by scnyig on 12/18/2017.
 */
public interface UserService {
    public UserDTO findUserByEmail(String email);
    public UserDTO saveUser(UserDTO user);
    public UserDTO findByUsername(String userName);
    public UserDTO findByName(String userName);
}
