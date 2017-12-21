package com.helloword.service;

import com.helloword.entity.Role;
import com.helloword.entity.User;
import com.helloword.repository.RoleRepository;
import com.helloword.repository.UserRepository;
import com.helloword.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by scnyig on 12/18/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO findUserByEmail(String email) {
        UserDTO userDTO = new UserDTO();
        User byEmail = userRepository.findByEmail(email);
        if (byEmail == null) return null;
        BeanUtils.copyProperties(byEmail,userDTO);
        return userDTO;
    }

    @Override
    public void saveUser(UserDTO userdto) {
        User user = new User();
        user.setEmail(userdto.getEmail());
//        user.setLastName(userdto.getLastName());
        user.setUsername(userdto.getName());
        user.setPassword(bCryptPasswordEncoder.encode(userdto.getPassword()));
//        user.setActive(1);
//        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(roleRepository.findAll()));
//        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
    }

    @Override
    public UserDTO findByUsername(String userName) {
        UserDTO userDTO = new UserDTO();
        User nameUser = userRepository.findByUsername(userName);
        BeanUtils.copyProperties(nameUser,userDTO);
        return userDTO;
    }
}
