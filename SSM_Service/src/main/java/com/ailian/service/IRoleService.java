package com.ailian.service;

import com.ailian.bean.Role;

import java.util.List;

public interface IRoleService {

    void saveRole(Role role);

    void saveRoleAndPermission(String roleCode, String permissionCode);

    void saveRoleAndPermissions(String roleCode, String[] permissionCodes);
    /**
     * 根据userCode查询对应的role信息
     * @param userCode
     * @return
     */
    List<Role> findRoleByUserCode(String userCode);

    List<Role> findRoleByNotUserCode(String userCode);

    List<Role> findAll(Integer page, Integer pageSize);

    Role findRoleByNotPermission(String code);
}
