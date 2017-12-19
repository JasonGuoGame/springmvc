package com.helloword.service;

import com.helloword.entity.Role;
import com.helloword.entity.User;

/**
 * Created by scnyig on 12/18/2017.
 */
public interface RoleService {
    public Role findRoleByName(String name);
}
