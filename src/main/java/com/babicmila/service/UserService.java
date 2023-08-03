package com.babicmila.service;

import com.babicmila.entity.User;

public interface UserService {

    User getUser(Long id);

    User saveUser(User user);
}
