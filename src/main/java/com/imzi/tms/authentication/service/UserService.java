package com.imzi.tms.authentication.service;

import com.imzi.tms.authentication.model.User;

public interface UserService {
    User save(User user);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
}
