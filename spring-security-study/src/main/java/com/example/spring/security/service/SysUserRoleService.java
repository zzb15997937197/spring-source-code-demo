package com.example.spring.security.service;


import com.example.spring.security.model.SysUserRole;
import com.example.spring.security.persistence.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        List<SysUserRole> sysUserRoles=userRoleMapper.listByUserId(userId);
        return sysUserRoles;
    }
}
