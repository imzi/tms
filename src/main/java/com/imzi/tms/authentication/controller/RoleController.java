package com.imzi.tms.authentication.controller;

import com.imzi.tms.authentication.dao.RoleDao;
import com.imzi.tms.authentication.model.Role;
import com.imzi.tms.authentication.model.User;
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

    @PostMapping("/role")
    public ResponseEntity<Role> save(@RequestBody Role user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
        return ResponseEntity.created(uri).body(roleDao.save(user));
    }
}
