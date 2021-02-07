package com.dejan.service;

import com.dejan.model.User;

public interface UserService {


    void save(User user);

    User findByUsername(String username);
}
