package com.example.spring.security.service;


import com.example.spring.security.model.SysUser;
import com.example.spring.security.persistence.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {


    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
       return userMapper.selectByName(name);
    }

}
