package com.imzi.tms.authentication.service;

import com.imzi.tms.authentication.dao.RoleDao;
import com.imzi.tms.authentication.dao.UserDao;
import com.imzi.tms.authentication.model.Role;
import com.imzi.tms.authentication.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null){
            log.error("Invalid user : {}", username);
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("Found the user : {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
