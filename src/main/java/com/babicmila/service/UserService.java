package com.babicmila.service;

import com.babicmila.entity.User;

public interface UserService {

    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
}
