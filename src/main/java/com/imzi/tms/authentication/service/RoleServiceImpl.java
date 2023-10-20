package com.imzi.tms.authentication.service;

import com.imzi.tms.authentication.dao.RoleDao;
import com.imzi.tms.authentication.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService{
    private final RoleDao roleDao;
    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }
}
