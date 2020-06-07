package com.example.spring.security.persistence;

import com.example.spring.security.model.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SysUserRoleMapper {


    @Select("select user_id as userId,role_id as roleId from sys_user_role where user_id=#{userId}")
    List<SysUserRole> listByUserId(@Param("userId") Integer userId);
}
