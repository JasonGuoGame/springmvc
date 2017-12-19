package com.helloword.service;

import com.helloword.entity.Role;
import com.helloword.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by scnyig on 12/18/2017.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByRole(name);
    }
}
