package com.example.spring.security.persistence;


import com.example.spring.security.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface SysUserMapper {



    @Select("SELECT * FROM sys_user where id=#{id}")
    SysUser selectById(@Param("id") int id);


    @Select("select * from sys_user where name=#{name}")
    SysUser selectByName(@Param("name") String name);
}
