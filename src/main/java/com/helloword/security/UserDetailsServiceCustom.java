package com.helloword.security;

import com.helloword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@Qualifier("userDetailsServiceCustom")
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    public UserDetailsServiceCustom(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.helloword.entity.User byName = userRepository.findByName(username);
        if(byName == null) return null;
        else
        return buildUserFromUserEntity(byName);
    }

    private UserDetails buildUserFromUserEntity(com.helloword.entity.User userEntity) {
        // convert model user to spring security user
        String username               = userEntity.getUsername();
        String password               = userEntity.getPassword();
        CustomUser user = new CustomUser();
        user.setFirstName(username);
        user.setLastName(userEntity.getUsername());
        user.setUsername(username);
        user.setPassword(password);
        SecurityRole r = new SecurityRole();
        r.setName("ROLE_USER");
        SecurityRole ad = new SecurityRole();
        ad.setName("ROLE_ADMIN");
        List<SecurityRole> roles = new ArrayList<SecurityRole>();
        roles.add(r);
        roles.add(ad);
        user.setAuthorities(roles);
        return user;
    }
}
