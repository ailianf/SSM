package com.ailian.dao;

import com.ailian.bean.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionDao {

    @Insert("insert into permission(code, permissionName, url) values(replace(UUID(), '-', ''), #{permissionName}, #{url}) ")
    void savePermission(Permission permission);

    @Select("select * from permission ")
    List<Permission> findAll();

    @Select("select * from permission where code = #{code}")
    List<Permission> findPermissionByCode(String code);


    @Select("select * from permission where code in (select permissionCode from role_permission where roleCode = #{roleCode}) ")
    List<Permission> findPermissionByRoleCode(String roleCode);

    @Select("select * from permission where code not in (select permissionCode from role_permission where roleCode = #{roleCode}) ")
    List<Permission> findPermissionByNotRoleCode(String roleCode);
}
