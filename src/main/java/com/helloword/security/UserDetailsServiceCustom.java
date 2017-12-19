package com.helloword.security;

import com.helloword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin on 15/1/10.
 */
@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    public UserDetailsServiceCustom(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.helloword.entity.User byName = userRepository.findByName(username);
        return buildUserFromUserEntity(byName);
    }

    private UserDetails buildUserFromUserEntity(com.helloword.entity.User userEntity) {
        // convert model user to spring security user
        String username               = userEntity.getName();
        String password               = userEntity.getPassword();
        CustomUser user = new CustomUser();
        user.setFirstName("kb");
        user.setLastName("gc");
        user.setUsername("kb");
        user.setPassword("1234");
        Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        user.setAuthorities(roles);
        return user;
    }
}
