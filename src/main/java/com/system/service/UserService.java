package com.system.service;

import com.system.entity.User;

import java.util.Optional;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
    List<User> findByName(String name);
    boolean isUserPresent(String email);
    void updateById(Long id, User user);
    void deleteById(Long id);
}
