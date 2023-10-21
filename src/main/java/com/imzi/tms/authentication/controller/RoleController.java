package com.imzi.tms.authentication.controller;

import com.imzi.tms.authentication.dao.RoleDao;
import com.imzi.tms.authentication.dao.UserDao;
import com.imzi.tms.authentication.model.Role;
import com.imzi.tms.authentication.model.User;
import com.imzi.tms.authentication.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleDao roleDao;
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Role> save(@RequestBody Role user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
        return ResponseEntity.created(uri).body(roleDao.save(user));
    }

    @PostMapping("/addToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser role){
        userService.addRoleToUser(role.getUserName(), role.getRoleName());
        return ResponseEntity.ok().build();
    }
}


@Data
class RoleToUser {
    private String userName;
    private String roleName;
}
