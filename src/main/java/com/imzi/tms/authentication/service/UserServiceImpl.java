package com.imzi.tms.authentication.service;

import com.imzi.tms.authentication.dao.RoleDao;
import com.imzi.tms.authentication.dao.UserDao;
import com.imzi.tms.authentication.model.Role;
import com.imzi.tms.authentication.model.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    private final RoleDao roleDao;
    @Override
    public User save(User user) {
        //TODO: Validation
        return userDao.save(user);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userDao.findByUsername(username);
        Role role = roleDao.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userDao.findByUsername(username);
    }
}
