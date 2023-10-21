package com.imzi.tms.authentication.controller;

import com.imzi.tms.authentication.dao.UserDao;
import com.imzi.tms.authentication.model.Role;
import com.imzi.tms.authentication.model.User;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path="/user")
@RequiredArgsConstructor
public class UserController {
    private UserDao userRepository;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(userRepository.save(user));
    }
}