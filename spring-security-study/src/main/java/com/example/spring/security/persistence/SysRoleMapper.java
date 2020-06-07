package com.example.spring.security.persistence;

import com.example.spring.security.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface SysRoleMapper {


    @Select("select * from sys_role where id=#{id}")
    SysRole selectById(@Param("id") Integer id);
}
