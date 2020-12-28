package com.system.service;

import com.google.common.collect.Lists;
import com.system.entity.Role;
import com.system.entity.RoleName;
import com.system.entity.User;
import com.system.exception.UserNotFoundException;
import com.system.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private static final String USER_WITH_ID_NOT_FOUND_MESSAGE = "User with id '%d' not found";
    private static final String USER_NOT_FOUND_MESSAGE = "User with email '%s' not found";

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Lists.newArrayList(roleService.findByName("USER")));
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException(String.format(USER_WITH_ID_NOT_FOUND_MESSAGE, id));
    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, email));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByName(String name) {
        return userRepository.findByNameLike(name);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isUserPresent(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    @Transactional
    public void updateById(Long id, User user) {
        //userRepository.updateById(Long id, User user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
