package com.ailian.dao;

import com.ailian.bean.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {

    @Insert("insert into role(code, roleName, roleDesc) values(replace(UUID(), '-', ''), #{roleName}, #{roleDesc}) ")
    void saveRole(Role role);

    @Insert("insert into role_permission(roleCode, permissionCode) values(#{roleCode}, #{permissionCode}) ")
    void saveRoleAndPermission(@Param("roleCode") String roleCode, @Param("permissionCode") String permissionCode);

    /**
     * 根据userCode查询对应的role信息
     * @param userCode
     * @return
     */
    @Select("select * from role where code in (select roleCode from user_role where userCode = #{userCode} ) ")
    @Results(
            value = {
                    @Result(id = true, property = "code", column = "code"),
                    @Result(property = "roleName", column = "roleName"),
                    @Result(property = "roleDesc", column = "roleDesc"),
                    @Result(property = "permissions", column = "code", javaType = List.class,
                            many = @Many(select = "com.ailian.dao.IPermissionDao.findPermissionByRoleCode", fetchType = FetchType.LAZY))
            }
    )
    List<Role> findRoleByUserCode(String userCode);

    @Select("select * from role where code not in (select roleCode from user_role where userCode = #{userCode} ) ")
    List<Role> findRoleByNotUserCode(String userCode);

    @Select("select * from role ")
    List<Role> findAll();

    @Select("select * from role where code = #{code}")
    @Results(
            value = {
                    @Result(id = true, property = "code", column = "code"),
                    @Result(property = "roleName", column = "roleName"),
                    @Result(property = "roleDesc", column = "roleDesc"),
                    @Result(property = "permissions", column = "code", javaType = List.class,
                            many = @Many(select = "com.ailian.dao.IPermissionDao.findPermissionByNotRoleCode", fetchType = FetchType.LAZY))
            }
    )
    Role findRoleByNotPermission(String code);

}
