package com.imzi.tms.authentication.dao;

import com.imzi.tms.authentication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
        Role findByName (String name);
}
